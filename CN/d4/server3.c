#include <sys/types.h>
#include <sys/socket.h>
#include <stdio.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>

#define SERVER_PORT 5017
#define CLIENT_PORT 5018

int main() {
    int sockfd = socket(AF_INET, SOCK_DGRAM, 0);
    if (sockfd == -1) {
        perror("Socket not created");
        return -1;
    }
    printf("Server created\n");

    struct sockaddr_in server_addr, client_addr;

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(SERVER_PORT);
    server_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    client_addr.sin_family = AF_INET;
    client_addr.sin_port = htons(CLIENT_PORT);
    client_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    if (bind(sockfd, (const struct sockaddr *)&server_addr, sizeof(server_addr)) == -1) {
        perror("Bind failed");
        exit(1);
    }
    printf("Bind success\n");

    // receive
    char charBuffer[100];
    int flags = 0;
    socklen_t temp = sizeof(client_addr);

    int rcv = recvfrom(sockfd, charBuffer, sizeof(charBuffer) - 1, flags,
                       (struct sockaddr *)&client_addr, &temp);
    if (rcv == -1) {
        perror("Receive error");
        close(sockfd);
        return -1;
    }
    charBuffer[rcv] = '\0';

    if (strcmp(charBuffer, "Krishna Mohanty") == 0) {
        // send
        char roll[50] = "2305386";
        int snd = sendto(sockfd, roll, strlen(roll), flags,
                         (const struct sockaddr *)&client_addr, sizeof(client_addr));
        if (snd == -1) {
            perror("Send error");
            close(sockfd);
            return -1;
        }
        printf("Roll number sent.\n");
    } else {
        printf("Error: Name does not match.\n");
    }

    close(sockfd);
    return 0;
}

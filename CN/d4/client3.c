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
    printf("Client socket created\n");

    struct sockaddr_in client_addr, server_addr;

    // Bind client to its own port
    client_addr.sin_family = AF_INET;
    client_addr.sin_port = htons(CLIENT_PORT);
    client_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    if (bind(sockfd, (const struct sockaddr *)&client_addr, sizeof(client_addr)) == -1) {
        perror("Bind failed");
        exit(1);
    }
    printf("Client bind success (Port %d)\n", CLIENT_PORT);

    // Set server address
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(SERVER_PORT);
    server_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    // Send name
    char name[100];
    printf("Enter your name: ");
    fgets(name, sizeof(name), stdin);
    name[strcspn(name, "\n")] = '\0'; 

    int flags = 0;
    int snd = sendto(sockfd, name, strlen(name), flags,
                     (const struct sockaddr *)&server_addr, sizeof(server_addr));
    if (snd == -1) {
        perror("Send Error");
        close(sockfd);
        return -1;
    }
    printf("Sent: %s\n", name);

    // Receive reply from server
    char charBuffer[100];
    socklen_t temp = sizeof(server_addr);

    int rcv = recvfrom(sockfd, charBuffer, sizeof(charBuffer) - 1, flags,
                       (struct sockaddr *)&server_addr, &temp);
    if (rcv == -1) {
        perror("Receiver Error");
        close(sockfd);
        return -1;
    }
    charBuffer[rcv] = '\0'; 
    printf("Message Received: %s\n", charBuffer);

    close(sockfd);
    return 0;
}

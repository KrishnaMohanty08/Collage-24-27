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

void do_receive(int sockfd, struct sockaddr_in *client_addr) {
    char charBuffer[100];
    int flags = 0;
    socklen_t temp = sizeof(*client_addr);

    int rcv = recvfrom(sockfd, charBuffer, sizeof(charBuffer) - 1, flags,
                       (struct sockaddr *)client_addr, &temp);
    if (rcv == -1) {
        perror("Receiver Error");
        return;
    }
    charBuffer[rcv] = '\0';
    printf("Message Received: %s\n", charBuffer);
}

void do_send(int sockfd, struct sockaddr_in *client_addr) {
    char charBuffer[100];
    int flags = 0;

    printf("Enter a message: ");
    scanf("%s", charBuffer);

    int snd = sendto(sockfd, charBuffer, strlen(charBuffer), flags,
                     (const struct sockaddr *)client_addr, sizeof(*client_addr));
    if (snd == -1) {
        perror("Send Error");
        return;
    }
    printf("Send Successful: %s\n", charBuffer);
}

int main() {
    int sockfd = socket(AF_INET, SOCK_DGRAM, 0);
    if (sockfd == -1) {
        perror("Socket not created");
        return -1;
    }
    printf("Server socket created\n");

    //struct sockaddr_in is a special structure defined in <netinet/in.h> for IPv4 addresses.
    struct sockaddr_in server_addr, client_addr;
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(SERVER_PORT);
    server_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    if (bind(sockfd, (const struct sockaddr *)&server_addr, sizeof(server_addr)) == -1) {
        perror("Bind failed");
        exit(1);
    }
    printf("Server bind success (Port %d)\n", SERVER_PORT);

    // Client address for sending
    client_addr.sin_family = AF_INET;
    client_addr.sin_port = htons(CLIENT_PORT);
    client_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    while (1) {
        int choice;
        printf("\n[Server] Enter 1 to receive, 2 to send, 0 to exit: ");
        scanf("%d", &choice);

        if (choice == 1)
            do_receive(sockfd, &client_addr);
        else if (choice == 2)
            do_send(sockfd, &client_addr);
        else if (choice == 0)
            break;
        else
            printf("Invalid choice\n");
    }

    close(sockfd);
    return 0;
}

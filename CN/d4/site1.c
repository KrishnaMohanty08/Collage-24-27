#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <unistd.h>

#define SERVER_PORT 5017
#define SERVER_IP "127.0.0.1"
#define BUFFER_SIZE 100

void sendMessage(int sockfd, struct sockaddr_in server_addr) {
    char buffer[BUFFER_SIZE];
    printf("Enter a message: ");
    scanf("%s", buffer);

    int flags = 0;
    int snd = sendto(sockfd, buffer, strlen(buffer), flags,
                     (struct sockaddr*)&server_addr, sizeof(server_addr));
    if (snd == -1) {
        perror("Send error");
        return;
    }
    printf("Send successful: %s\n", buffer);
}

void receiveMessage(int sockfd) {
    char buffer[BUFFER_SIZE];
    struct sockaddr_in from_addr;
    socklen_t from_len = sizeof(from_addr);
    int flags = 0;

    int rcv = recvfrom(sockfd, buffer, sizeof(buffer) - 1, flags,
                       (struct sockaddr*)&from_addr, &from_len);
    if (rcv == -1) {
        perror("Receive error");
        return;
    }
    buffer[rcv] = '\0';
    printf("Message received: %s\n", buffer);
}

int main() {
    int sockfd;
    struct sockaddr_in client_addr, server_addr;

    sockfd = socket(AF_INET, SOCK_DGRAM, 0);
    if (sockfd == -1) {
        perror("Socket creation failed");
        return -1;
    }
    printf("Socket created\n");

    // Bind client to any available port
    client_addr.sin_family = AF_INET;
    client_addr.sin_port = htons(0); // 0 = auto-assign
    client_addr.sin_addr.s_addr = inet_addr(SERVER_IP);

    if (bind(sockfd, (struct sockaddr*)&client_addr, sizeof(client_addr)) == -1) {
        perror("Bind failed");
        close(sockfd);
        return -1;
    }

    // Configure server details
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(SERVER_PORT);
    server_addr.sin_addr.s_addr = inet_addr(SERVER_IP);

    int choice;
    printf("Enter 1 to send, 2 to receive: ");
    scanf("%d", &choice);

    if (choice == 1)
        sendMessage(sockfd, server_addr);
    else
        receiveMessage(sockfd);

    close(sockfd);
    return 0;
}

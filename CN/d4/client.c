#include <sys/types.h>          
#include <sys/socket.h>
#include <stdio.h>
#include <netinet/in.h>
#include <netinet/ip.h>
#include <arpa/inet.h>
#include <string.h>

int main(int argc,char  *argv[]){
	int sockfd=socket(AF_INET,SOCK_DGRAM,0);
	if(sockfd==-1)
		printf("socket not created\n");
	else
		printf("Socket created\n");
		
	//bind
	struct sockaddr_in client_addr,server_addr;
	
        client_addr.sin_family=AF_INET;
      	client_addr.sin_port=htons(5017);
        client_addr.sin_addr.s_addr=inet_addr("127.0.0.1");

        int bind1=bind(sockfd,(const struct sockaddr*)(&client_addr),sizeof(client_addr));

    if(bind1==-1)
		printf("bind failed\n");
	else 
		printf("bind success\n");
		
	//Creating a character buffer
	char charBuffer[100];
	printf("enter a message :");
	scanf("%s",charBuffer);
	
	//send to function 
	int flags=0;
	
	server_addr.sin_family=AF_INET;
        server_addr.sin_port=htons(5017);
        server_addr.sin_addr.s_addr=inet_addr("127.0.0.1");

    // ssize_t sendto(
    // int sockfd,                // socket file descriptor
    // const void *buf,           // data buffer to send
    // size_t len,                // number of bytes to send
    // int flags,                 // special sending flags
    // const struct sockaddr *dest_addr, // destination address
    // socklen_t addrlen           // size of destination address structure
	// );
	
	int snd=sendto(sockfd,charBuffer,strlen(charBuffer),flags,(const struct sockaddr*)(&server_addr),sizeof(server_addr));
	if(snd==-1){
		printf("SendError!\n");
		return -1;
		}
	printf("Send Successfull %s",charBuffer);
	

	return 0;
}



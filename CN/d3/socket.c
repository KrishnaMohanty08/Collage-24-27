#include <sys/types.h>          
#include <sys/socket.h>
#include <stdio.h>
#include <netinet/in.h>
#include <netinet/ip.h>
#include <arpa/inet.h>

int main(){
	int sockfd=socket(AF_INET,SOCK_DGRAM,0);
	if(sockfd==-1)
		printf("socket not created\n");
	else
		printf("Socket created\n");
		
	//bind
	struct sockaddr_in myaddr;
	
        myaddr.sin_family=AF_INET;
        myaddr.sin_port=htons(5017);
        myaddr.sin_addr.s_addr=inet_addr("127.0.0.1");
        
        int bind1=bind(sockfd,(const struct sockaddr*)(&myaddr),sizeof(myaddr));
        if(bind1==-1)
		printf("bind failed\n");
	else 
		printf("bind success\n");
	return 0;
}


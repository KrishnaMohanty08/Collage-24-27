#include <stdio.h>

int isLittleEndian() {
    unsigned int x = 1;
    return ((char)&x);
}

unsigned int reverseBytes(unsigned int num) {
    unsigned int b0, b1, b2, b3;
    b0 = (num & 0x000000FF) >> 0;
    b1 = (num & 0x0000FF00) >> 8;
    b2 = (num & 0x00FF0000) >> 16;
    b3 = (num & 0xFF000000) >> 24;

    return (b0 << 24) | (b1 << 16) | (b2 << 8) | (b3 << 0);
}

int main() {
    unsigned int num;
    printf("Enter an unsigned integer: ");
    scanf("%u", &num);

    printf("\nOriginal number: %u\n", num);

    if (isLittleEndian()) {
        printf("System is Little Endian.\n");
    } else {
        printf("System is Big Endian.\n");
    }

    unsigned char *ptr = (unsigned char *)&num;
    printf("Byte positions and values:\n");
    for (int i = 0; i < sizeof(num); i++) {
        printf("Byte %d: 0x%02X\n", i, ptr[i]);
    }

    unsigned int converted = reverseBytes(num);
    printf("Number after converting endianess: %u\n", converted);

    unsigned char *cptr = (unsigned char *)&converted;
    printf("Byte positions and values after conversion:\n");
    for (int i = 0; i < sizeof(converted); i++) {
        printf("Byte %d: 0x%02X\n", i, cptr[i]);
    }

    return 0;
}
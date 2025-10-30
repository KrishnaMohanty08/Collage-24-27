#include <stdio.h>
#include <stdlib.h>

typedef struct SYMBOL {
    char alphabet;
    int frequency;
    struct SYMBOL *left, *right;
} SYMBOL;

// Create node
SYMBOL *createNode(char alphabet, int frequency) {
    SYMBOL *node = (SYMBOL *)malloc(sizeof(SYMBOL));
    node->alphabet = alphabet;
    node->frequency = frequency;
    node->left = node->right = NULL;
    return node;
}

// Swap function
void swap(SYMBOL **a, SYMBOL **b) {
    SYMBOL *temp = *a;
    *a = *b;
    *b = temp;
}

// Heapify
void heapify(SYMBOL *heap[], int n, int i) {
    int smallest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && heap[left]->frequency < heap[smallest]->frequency)
        smallest = left;
    if (right < n && heap[right]->frequency < heap[smallest]->frequency)
        smallest = right;

    if (smallest != i) {
        swap(&heap[i], &heap[smallest]);
        heapify(heap, n, smallest);
    }
}

// Extract minimum node
SYMBOL *extractMin(SYMBOL *heap[], int *n) {
    SYMBOL *minNode = heap[0];
    heap[0] = heap[*n - 1];
    (*n)--;
    heapify(heap, *n, 0);
    return minNode;
}

// Insert node into heap
void insertHeap(SYMBOL *heap[], int *n, SYMBOL *node) {
    (*n)++;
    int i = *n - 1;
    heap[i] = node;

    while (i != 0 && heap[(i - 1) / 2]->frequency > heap[i]->frequency) {
        swap(&heap[i], &heap[(i - 1) / 2]);
        i = (i - 1) / 2;
    }
}

// Build Huffman tree
SYMBOL *buildHuffmanTree(SYMBOL *heap[], int n) {
    while (n > 1) {
        SYMBOL *left = extractMin(heap, &n);
        SYMBOL *right = extractMin(heap, &n);

        SYMBOL *newNode = createNode('$', left->frequency + right->frequency);
        newNode->left = left;
        newNode->right = right;

        insertHeap(heap, &n, newNode);
    }
    return heap[0];
}

// Inorder traversal
void inorder(SYMBOL *root) {
    if (root == NULL)
        return;
    inorder(root->left);
    if (root->alphabet != '$')
        printf("%c(%d) ", root->alphabet, root->frequency);
    inorder(root->right);
}

// Print tree (visual)
void printTree(SYMBOL *root, int level) {
    if (root == NULL)
        return;
    printTree(root->right, level + 1);
    for (int i = 0; i < level; i++)
        printf("    ");
    if (root->alphabet != '$')
        printf("%c(%d)\n", root->alphabet, root->frequency);
    else
        printf("$ (%d)\n", root->frequency);
    printTree(root->left, level + 1);
}

int main() {
    int n;
    printf("Enter the number of distinct alphabets: ");
    scanf("%d", &n);

    char alphabets[n];
    int freq[n];

    printf("Enter the alphabets: ");
    for (int i = 0; i < n; i++) {
        scanf(" %c", &alphabets[i]); // space before %c fixes newline issue
    }

    printf("Enter the frequencies: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &freq[i]);
    }

    SYMBOL *heap[n];
    for (int i = 0; i < n; i++) {
        heap[i] = createNode(alphabets[i], freq[i]);
    }

    // Build initial heap
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(heap, n, i);
    }

    SYMBOL *root = buildHuffmanTree(heap, n);

    printf("\nHuffman Tree (sideways view):\n");
    printTree(root, 0);

    printf("\nInorder Traversal of Huffman Tree:\n");
    inorder(root);
    printf("\n");

    return 0;
}

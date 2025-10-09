#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    char alphabet;
    int frequency;
    struct Node *left, *right;
} Node;

typedef struct {
    Node **arr;
    int size;
} MinHeap;

Node* createNode(char alphabet, int frequency) {
    Node* node = (Node*)malloc(sizeof(Node));
    node->alphabet = alphabet;
    node->frequency = frequency;
    node->left = node->right = NULL;
    return node;
}

void swap(Node **a, Node **b) {
    Node *temp = *a;
    *a = *b;
    *b = temp;
}

void heapify(MinHeap *heap, int i) {
    int smallest = i, l = 2*i + 1, r = 2*i + 2;
    if (l < heap->size && heap->arr[l]->frequency < heap->arr[smallest]->frequency)
        smallest = l;
    if (r < heap->size && heap->arr[r]->frequency < heap->arr[smallest]->frequency)
        smallest = r;
    if (smallest != i) {
        swap(&heap->arr[i], &heap->arr[smallest]);
        heapify(heap, smallest);
    }
}

Node* extractMin(MinHeap *heap) {
    Node* min = heap->arr[0];
    heap->arr[0] = heap->arr[heap->size - 1];
    heap->size--;
    heapify(heap, 0);
    return min;
}

void insertHeap(MinHeap *heap, Node *node) {
    int i = heap->size++;
    heap->arr[i] = node;
    while (i && heap->arr[(i-1)/2]->frequency > heap->arr[i]->frequency) {
        swap(&heap->arr[i], &heap->arr[(i-1)/2]);
        i = (i-1)/2;
    }
}

void inorder(Node *root) {
    if (!root) return;
    inorder(root->left);
    if (root->alphabet != '#') 
        printf("%c ", root->alphabet);
    inorder(root->right);
}

int main() {
    int n;
    printf("Enter the number of distinct alphabets: ");
    scanf("%d", &n);

    char alphabets[n];
    int freq[n];
    printf("Enter the alphabets: ");
    for (int i = 0; i < n; i++)
        scanf(" %c", &alphabets[i]);
    printf("Enter its frequencies: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &freq[i]);

    MinHeap heap;
    heap.arr = (Node**)malloc(n * sizeof(Node*));
    heap.size = 0;
    for (int i = 0; i < n; i++)
        insertHeap(&heap, createNode(alphabets[i], freq[i]));

    while (heap.size > 1) {
        Node *left = extractMin(&heap);
        Node *right = extractMin(&heap);
        Node *newNode = createNode('#', left->frequency + right->frequency);
        newNode->left = left;
        newNode->right = right;
        insertHeap(&heap, newNode);
    }

    printf("In-order traversal of the tree (Huffman): ");
    inorder(heap.arr[0]);
    printf("\n");

    // Free memory 
    free(heap.arr);
    return 0;
}

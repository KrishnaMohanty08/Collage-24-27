#include <stdio.h>
#include<stdlib.h>
struct ITEM 
{
    int item_id;
    float item_profit;
    float item_weight;
    float profit_weight_ratio;
};
void heapify(struct ITEM arr[], int n, int i) 
{
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (left < n && arr[left].profit_weight_ratio > arr[largest].profit_weight_ratio)
        largest = left;

    if (right < n && arr[right].profit_weight_ratio > arr[largest].profit_weight_ratio)
        largest = right;

    if (largest != i) 
    {
        struct ITEM temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;

        heapify(arr, n, largest);
    }
}

void heapSort(struct ITEM arr[], int n) 
{
    
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    for (int i = n - 1; i >= 0; i--) 
    {
        struct ITEM temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
         heapify(arr, i, 0);
    }

    for (int i = 0; i < n / 2; i++) 
    {
        struct ITEM temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;
    }
}

int main() 
{
    int n;
    float capacity;

    printf("Enter the number of items: ");
    scanf("%d", &n);

    struct ITEM items[n];

    for (int i = 0; i < n; i++) {
        printf("Enter the profit and weight of item no %d: ", i + 1);
        scanf("%f %f", &items[i].item_profit, &items[i].item_weight);
        items[i].item_id = i + 1;
        items[i].profit_weight_ratio = items[i].item_profit / items[i].item_weight;
    }

    printf("Enter the capacity of knapsack: ");
    scanf("%f", &capacity);
    heapSort(items, n);

    float total_profit = 0.0, fraction[n];

    for (int i = 0; i < n; i++) {
        if (capacity >= items[i].item_weight) {
            fraction[i] = 1.0;
            total_profit += items[i].item_profit;
            capacity -= items[i].item_weight;
        } else {
            fraction[i] = capacity / items[i].item_weight;
            total_profit += items[i].item_profit * fraction[i];
            capacity = 0; 
        }
    }

    printf("\nItem No\tprofit\tWeight\tAmount to be taken\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t%f\t%f\t%f\n", items[i].item_id, items[i].item_profit,
               items[i].item_weight, fraction[i]);
    }

    printf("Maximum profit: %f\n", total_profit);

    return 0;
}
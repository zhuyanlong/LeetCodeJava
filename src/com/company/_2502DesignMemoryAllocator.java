package com.company;

public class _2502DesignMemoryAllocator {
    public static void main(String[] args) {
        Allocator loc = new Allocator(10);
        loc.allocate(1, 1);
        loc.allocate(1, 2);
        loc.allocate(1, 3);
        loc.free(2);
        loc.allocate(3, 4);
        loc.allocate(1, 1);
        loc.allocate(1, 1);
        loc.free(1);
        loc.allocate(10, 2);
        loc.free(7);
    }
}

class Allocator {
    int[] array;

    public Allocator(int n) {
        this.array = new int[n];
    }

    public int allocate(int size, int mID) {
        int flag = 0;
        int count = 0;
        int j = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == 0) {
                count++;
                if (count == size) {
                    flag = 1;
                    break;
                }
            } else {
                count = 0;
                j = i + 1;
            }
        }
        if (flag == 1) {
            for (int i = j ; i < j + size; i++) {
                this.array[i] = mID;
            }
            return j;
        }
        return -1;
    }

    public int free(int mID) {
        int count = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == mID) {
                this.array[i] = 0;
                count++;
            }
        }
        return count;
    }
}
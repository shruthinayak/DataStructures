package com.practice.hashing;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyMap {
    float loadFactor = 0.75f;
    int tableSize = 30;
    double k;
    LinkedList[] keys;
    LinkedList[] values;
    Set<String> keySet;
    int collisions = 0;

    MyMap() {
        init(tableSize);
    }

    MyMap(int tableSize) {
        this.tableSize = tableSize;
        init(tableSize);
    }

    public static void main(String[] args) {
        MyMap map = new MyMap();
        String[] randomStrings = new String[]{
                "yjUpRL2blq", "9xzQmsSHtm", "LoPBmuVtRZ", "Rp4yHa1tM3", "fOeZvFFUHD", "gn9m3FmV9j", "XKzuVYGtoi", "LoSi4ct40w", "d34rDrvyYL", "k19z2qROfj", "eac04pca8x", "URvxQz5hGW", "dNA42EYjlY", "19gLawNvOE", "jTkMmz8fq5", "hZeYJ6QCA3", "eSDw82pmUQ", "ZeTrpw3sqz", "ltJwvScj4N", "Rkme67RkYm"};
        for (String i : randomStrings) {
            map.put(i, "");
        }
        System.out.println("Number of collisions of a map with table size " + map.tableSize + " is " + map.collisions);
        map.print();
    }

    protected void init(int tableSize) {
        this.k = 0;
        this.keys = new LinkedList[tableSize];
        this.values = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            this.keys[i] = new LinkedList<>();
            this.values[i] = new LinkedList<>();
        }
        keySet = keySet();
    }

    protected void resize() {
        MyMap newTable = new MyMap(tableSize * 2);
        Set<String> keyS = keySet();
        for (String key : keyS) {
            newTable.put(key, get(key));
        }
        tableSize = tableSize * 2;
        keys = newTable.keys;
        values = newTable.values;
        keySet = keySet();
    }

    public int hashFunction(String obj) {
        int key = 17 * 31 + obj.hashCode();
        if (key < 0)
            key = ~key;
        return (key % tableSize);
    }

    public void put(String key, Object value) {
        int index = hashFunction(key);
        insert(key, value, index);
    }

    protected void insert(String key, Object value, int index) {

        if (!find(key)) {
            if (isResizeNecessary()) {
                resize();
            }
            keys[index].add(key);
            if (keys[index].size() > 1) {
                collisions++;
            }
            values[index].add(keys[index].size() - 1, value);
            k++;
            keySet.add(key);
        } else {
            int indexList = keys[index].indexOf(key);
            values[index].set(indexList, value);
        }
    }


    public Object get(String key) {
        if (find(key)) {
            int index = hashFunction(key);
            int indexInList = keys[index].indexOf(key);
            return values[index].get(indexInList);
        } else return null;

    }

    public Set<String> keySet() {
        if (keySet == null) {
            keySet = new HashSet<>();
            for (LinkedList keyList : keys) {
                keySet.addAll(keyList);
            }
        }
        return keySet;
    }

    boolean find(String obj) {
        int i = hashFunction(obj);
        return keys[i] != null && keys[i].contains(obj);
    }


    public boolean isResizeNecessary() {
        double v = k / tableSize;
        return v > loadFactor;
    }

    public void print() {
        for (int j = 0; j < keys.length; j++) {
            LinkedList i = keys[j];
            System.out.print(j + ": ");
            for (int index = 0; index < i.size(); index++) {
                System.out.print(i.get(index) + ", ");
            }
            System.out.println();
        }
    }
}
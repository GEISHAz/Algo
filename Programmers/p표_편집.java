package Programmers;

import java.util.Stack;

class TableEditor {
    private int tableSize;
    private int cursor;
    private Stack<Integer> removed;

    public TableEditor(int n, int k) {
        this.tableSize = n;
        this.cursor = k;
        this.removed = new Stack<>();
    }

    public void moveDown(int x) {
        cursor = Math.min(cursor + x, tableSize - 1);
    }

    public void moveUp(int x) {
        cursor = Math.max(cursor - x, 0);
    }

    public void delete() {
        removed.push(cursor);
        tableSize--;
        if (cursor == tableSize) {
            cursor--;
        }
    }

    public void restore() {
        int restoredIndex = removed.pop();
        if (restoredIndex <= cursor) {
            cursor++;
        }
        tableSize++;
    }

    public String getResult() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tableSize; i++) {
            builder.append("O");
        }
        while (!removed.isEmpty()) {
            builder.insert(removed.pop(), "X");
        }
        return builder.toString();
    }

    public void processCommand(String cmd) {
        char type = cmd.charAt(0);
        if (type == 'D') {
            moveDown(Integer.parseInt(cmd.substring(2)));
        } else if (type == 'U') {
            moveUp(Integer.parseInt(cmd.substring(2)));
        } else if (type == 'C') {
            delete();
        } else if (type == 'Z') {
            restore();
        }
    }
}

class p표_편집 {
    public String solution(int n, int k, String[] cmd) {
        TableEditor editor = new TableEditor(n, k);

        for (String command : cmd) {
            editor.processCommand(command);
        }

        return editor.getResult();
    }
}

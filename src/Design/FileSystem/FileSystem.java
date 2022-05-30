class FileSystem {
    TrieNode root = new TrieNode();

    public List<String> ls(String path) {
        TrieNode curNode = root;
        if (!path.equals("/")) {
            // Find the directory
            String[] list = path.split("/");
            String curString;
            for (int i = 1; i < list.length; i++) {
                curString = list[i];
                curNode = curNode.children.get(curString);
                // Check if it is file path
                if (i == list.length - 1 && curNode.content != null) {
                    return Arrays.asList(curString);
                }
            }
        }
        List<String> children = new LinkedList<>(curNode.children.keySet());
        return children;
    }

    public void mkdir(String path) {
        TrieNode curNode = root;
        String[] arr = path.split("/");
        for (int i = 1; i < arr.length; i++) {
            String curString = arr[i];
            if (!curNode.children.containsKey(curString)) {
                curNode.children.put(curString, new TrieNode());
            }
            curNode = curNode.children.get(curString);
        }
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode curNode = root;
        String[] arr = filePath.split("/");
        for (int i = 1; i < arr.length; i++) {
            String curString = arr[i];
            if (!curNode.children.containsKey(curString)) {
                curNode.children.put(curString, new TrieNode());
            }
            curNode = curNode.children.get(curString);
        }
        if (curNode.content != null) {
            curNode.content += content;
        } else {
            curNode.content = content;
        }
    }

    public String readContentFromFile(String filePath) {
        TrieNode curNode = root;
        String[] arr = filePath.split("/");
        for (int i = 1; i < arr.length; i++) {
            String curString = arr[i];
//             if (!curNode.children.containsKey(curString)) {
//                 curNode.children.put(curString, new TrieNode());
//             }
            curNode = curNode.children.get(curString);
        }
        return curNode.content;
    }
}

class TrieNode {
    String content = null;
    Map<String, TrieNode> children = new TreeMap<>();
}

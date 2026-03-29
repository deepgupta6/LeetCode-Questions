class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        int i = 0;
        int cnt = 0;
        sb.append('/');

        while (i < path.length()) {

            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }

            temp.setLength(0);
            cnt = 0;

            while (i < path.length() && path.charAt(i) != '/') {
                if (path.charAt(i) == '.')
                    cnt++;
                temp.append(path.charAt(i));
                i++;
            }

            if (cnt == 1 && temp.length() == 1) {
                continue;
            }

            else if (cnt == 2 && temp.length() == 2) {
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1); // remove '/'
                    while (sb.length() > 0 && sb.charAt(sb.length() - 1) != '/') {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }

            else if (temp.length() > 0) {
                sb.append(temp).append('/');
            }
        }

        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}

// more clean code using stack and string array

class Solution2 {
    public String simplifyPath(String path) {

        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String part: parts){
            if (part.equals("") || part.equals(".")) {
                continue;
            } 
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            else {
                stack.push(part);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
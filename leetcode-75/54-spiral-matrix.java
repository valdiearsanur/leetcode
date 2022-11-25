class Solution {
    int boundRight;
    int boundDown;
    int boundLeft;
    int boundUp;

    public List<Integer> moveRight(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i=boundLeft; i<=boundRight; i++) {
            result.add(matrix[boundUp][i]);
        }
        boundUp += 1;
        return result;
    }
    
    public List<Integer> moveDown(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i=boundUp; i<=boundDown; i++) {
            result.add(matrix[i][boundRight]);
        }
        boundRight -= 1;
        return result;
    }

    public List<Integer> moveLeft(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i=boundRight; i>=boundLeft; i--) {
            result.add(matrix[boundDown][i]);
        }
        boundDown -= 1;
        return result;
    }

    public List<Integer> moveUp(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i=boundDown; i>=boundUp; i--) {
            result.add(matrix[i][boundLeft]);
        }
        boundLeft += 1;
        return result;
    }

    public boolean checkBound() {
        return boundUp<=boundDown && boundLeft<=boundRight;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        boundUp = 0;
        boundLeft = 0;
        boundDown = matrix.length-1;
        boundRight = matrix[0].length-1;
        while (checkBound()) {
            if (checkBound()) result.addAll(moveRight(matrix));
            if (checkBound()) result.addAll(moveDown(matrix));
            if (checkBound()) result.addAll(moveLeft(matrix));
            if (checkBound()) result.addAll(moveUp(matrix));
        }
        return result;
    }
}

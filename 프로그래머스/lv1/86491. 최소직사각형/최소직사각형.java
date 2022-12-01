class Solution {
    public int solution(int[][] sizes) {
        int widthMax = 0;
        int heightMax = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                if (sizes[i][0] > widthMax) {
                    widthMax = sizes[i][0];
                }

                if (sizes[i][1] > heightMax) {
                    heightMax = sizes[i][1];
                }
            } else {
                if (sizes[i][1] > widthMax) {
                    widthMax = sizes[i][1];
                }

                if (sizes[i][0] > heightMax) {
                    heightMax = sizes[i][0];
                }
            }
        }
        return widthMax * heightMax;
    }
}
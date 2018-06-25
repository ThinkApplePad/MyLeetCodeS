public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len_1 = nums1.length;
        int len_2 = nums2.length;
        
        if (len_1 > len_2) {
            return findMedianSortedArrays(nums2, nums1);
        } 
        
        int start = 0;
        int end   = len_1;
        int partition_x, partition_y;
        int minXleft, maxXright, minYleft, maxYright;
        
        while (start <= end) {
            partition_x = (start + end) / 2;
            partition_y = (len_1 + len_2 + 1) / 2 - partition_x;
            
            minXleft  = partition_x == 0 ? Integer.MIN_VALUE : nums1[partition_x - 1];
            maxXright = partition_x == len_1 ? Integer.MAX_VALUE : nums1[partition_x];
            minYleft  = partition_y == 0 ? Integer.MIN_VALUE : nums2[partition_y - 1];
            maxYright = partition_y == len_2 ? Integer.MAX_VALUE : nums2[partition_y];
            
            if (minXleft <= maxYright && minYleft <= maxXright) {
                if ((len_1 + len_2) % 2 == 0) {
                    return (double)((Math.max(minXleft, minYleft) + Math.min(maxXright, maxYright))) / 2.0;
                }
                else {
                    return (double)Math.max(minXleft, minYleft);
                }
            }
            else if (minXleft > maxYright) {
                end = partition_x - 1;     // current x's partition -1
            }
            else {
                start = partition_x + 1;
            }
            
        }
        return 0;
    }

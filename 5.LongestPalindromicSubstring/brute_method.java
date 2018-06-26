public static String longestPalindrome(String s) {
    int x = 0, y = 0;
    int max_len = 0;
    for (int i = 0; i < s.length(); i++) {
        for (int j = i; j < s.length(); j++){
            if (isPalindrome(s.substring(i, j + 1),i,j) && max_len < j - i + 1){
                max_len = j - i + 1;
                x = i;
                y = j;
            }
        }
    }
    return s.substring(x, y + 1);
}

// 使用函数，将功能分开
public static boolean isPalindrome(String ss, int start, int end)
{
    int flag = 0;
    int i = start;
    int j = end;

    if (end - start == 0) {
        return true;
  
    for ( ; i < j; i++, j--) {
        if (ss.charAt(i - start) != ss.charAt(j - start)){
            return false;
        }
        else {
            flag = 1;
        }
  
    if (flag == 1) {
        return true;
    }
    else {
        return false;
    }
}

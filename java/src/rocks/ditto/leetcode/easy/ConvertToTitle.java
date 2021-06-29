package src.rocks.ditto.leetcode.easy;

public class ConvertToTitle {

    /**
     * 168. Excel表列名称
     * https://leetcode-cn.com/problems/excel-sheet-column-title/
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        // 一般性的进制转换题目无须进行额外操作，是因为我们是在「每一位数值范围在 [0,x)」的前提下进行「逢 x 进一」。
        //但本题需要我们将从 1 开始，因此在执行「进制转换」操作前，我们需要先对 columnNumber 执行减一操作，从而实现整体偏移。
        //链接：https://leetcode-cn.com/problems/excel-sheet-column-title/solution/gong-shui-san-xie-cong-1-kai-shi-de-26-j-g2ur/
        StringBuilder s = new StringBuilder();
        while (columnNumber > 0){
            columnNumber--;
            s.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        convertToTitle.convertToTitle(27);
    }
}

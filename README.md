# findSmallerMax
A solution to the question: Given a number 'X', output the largest number smaller than the number 'X' that can be obtained by swapping different bits of the number.  

author:gszswork  
Question:Given a number 'X', output the largest number smaller than the number 'X' that can be obtained  
          by swapping different bits of the number  
Example: input: 21345   output: 12543  
Idea: 从数字个位开始向前扫描，如果存在某一位数值小于前一位，则交换这两位，并且将已扫描的部分翻转后添加到交换的两位后面。  
   考虑到题目对于数字的限制是数字的位数在1000以内，直接采用char来表示每一位，程序只对char和String进行操作会更加方便。  
running time limitted: 1s  
length of X: 0-1000. 

#include<iostream.h>
#include<conio.h>
int main() {
clrscr();
int num1[255], num2[255], sum[255];
char s1[255], s2[255];
int l1, l2;

cout<<"enter 1 number--------->";
cin>>s1;
cout<<"enter 2 number--------->";
cin>>s2;
/* convert character to integer*/
for (l1 = 0; s1[l1] != '\0'; l1++)
num1[l1] = s1[l1] - '0';

for (l2 = 0; s2[l2] != '\0'; l2++)
num2[l2] = s2[l2] - '0';

int carry = 0;
int k = 0;
int i = l1 - 1;
int j = l2 - 1;
for (; i >= 0 && j >= 0; i--, j--, k++) {
sum[k] = (num1[i] + num2[j] + carry) % 10;
carry = (num1[i] + num2[j] + carry) / 10;
}
if (l1 > l2) {

while (i >= 0) {
sum[k++] = (num1[i] + carry) % 10;
carry = (num1[i--] + carry) / 10;
}

} else if (l1 < l2) {
while (j >= 0) {
sum[k++] = (num2[j] + carry) % 10;
carry = (num2[j--] + carry) / 10;
}
} else {
if (carry > 0)
sum[k++] = carry;
}
cout<<"result---->";
for (k--; k >= 0; k--)
cout<<sum[k];
getch();
return 0;
}

















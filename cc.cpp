#include<iostream.h>
#include<fstream.h>
#include<string.h>

int main ()
{
char line[100];
charch;
charlang[20];
ifstreamifile,rfile,cfile;
ofstreamofile,oufile,outfile;
    {
		ifile.open ("infile.txt",ios::in);
		ofile.open ("result.txt",ios::trunc|ios::out);
		cout<<"enter character to copy the lines from input file(f/m/r/s):";
		cin>>ch;
		while(!ifile.eof())
		{
			ifile.getline(line,60);
			if(line[9]==ch)
			{
			ofile<<line<<endl;
			}

		}
		cout<<"done\n";

		ifile.close();
		ofile.close();
	}
	{
		rfile.open("result.txt",ios::in);
		oufile.open("cleared.txt",ios::trunc|ios::out);
		cout<<"copying data\n ";
		while(!rfile.eof())
		{
			rfile.getline(line,100);
			inti=14;
			oufile<<"\"";
			while(line[i]!='"')
			{
			oufile<<line[i];
			i++;

			}
			oufile<<"\""<<endl;
		}
		cout<<"done\n";
		rfile.close();
		oufile.close();
	}
	{
		cfile.open ("cleared.txt",ios::in);
		outfile.open ("final.bat",ios::trunc|ios::out);
		cout<<"enter the language you wanted to associate\n";
		cin>>lang;
		while(!cfile.eof())
		{

			cfile.getline(line,50);
			outfile<<lang<<line<<endl;

		}
		cout<<"done\n";
		cfile.close();
		outfile.close();
	}
return 0;
}




















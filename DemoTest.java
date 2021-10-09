package 作业.数据导入与导出;
import java.sql.*;
import java.io.*;
public class DemoTest {
	File file = new File("F:\\src","图书信息.txt");
	PreparedStatementDemo demo = new PreparedStatementDemo();
	FileReader reader;
	BufferedReader br;
	FileWriter writer;
	BufferedWriter bw;
	ResultSet rs = null;
	String str[] = null;
	public void write(String selectSql) {
		try {
			writer = new FileWriter(file);
			bw = new BufferedWriter(writer);
			demo.Connection();
			rs = demo.executeQuery(selectSql,null);
			String str = null;
			while(rs.next()) {
				str=rs.getString(1)+"，"+rs.getString(2)+"，"+rs.getString(3)+"，"+rs.getString(4)+"，"+rs.getString(5);
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			writer.close();
			System.out.println("写入成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void read(String insertSql) {
		int num = 0;
		try {
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			String s = null;
			while((s=br.readLine())!=null) {
				str = s.split("，");
				num = demo.executeUpdate(insertSql, str);
				num++;
			}
			System.out.println("成功插入"+num+"行");
			br.close();
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

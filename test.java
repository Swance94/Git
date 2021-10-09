package 作业.数据导入与导出;

public class test {
	public static void main(String[] args) {
		DemoTest test = new DemoTest();
		String insertSql = "insert into book(name,author,press,price,introduction) values(?,?,?,?,?);";
		String selectSql = "select * from book;";
		test.read(insertSql);
	}
}

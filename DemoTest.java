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

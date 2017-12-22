package ohho.servlet;
import java.util.Date;

import ohho.dao.ExtensionDao;
import ohho.tools.RandomBirstday;
public class AddExtension {
	public   void add_extension(int user_id){
		ExtensionDao extension = new ExtensionDao();
		RandomBirstday randomBirstday = new RandomBirstday();
		int[] sex_arr = {1,2,3};
		int index=(int)(Math.random()*sex_arr.length);
		int sex = sex_arr[index];
		Date random_birstday = randomBirstday.randomDate("1980-01-01", "2017-03-01");
		extension.add_Extension(user_id, sex, random_birstday);
	}
}

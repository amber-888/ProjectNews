package com.example.webtest.sqlRules;
import com.example.webtest.openweb.rules;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Datadao extends rules implements BaseDao {

    public static List<String> female_students = new ArrayList<String>(); //定义一个list存放女性学生

    public static List<String> male_students = new ArrayList<String>(); //定义一个数组存放男性学生；

    public static String hours;

    @RequestMapping("/add")
    public void getData() throws SQLException, FileNotFoundException {

        rules datas = new rules();

        String name = datas.getName(); //获取规则传过来的名字，可随机

        String num = datas.getStudentNum(); //获取规则传过来的学号，可随机

        String sex = datas.getSex(); //获取规则传过来的性别，可随机

        String timeslice = datas.getTimeslice(); //获取规则传过来的时间区间，可随机

        String web_name = datas.getWebName(); //获取规则传过来的网站名字，可随机

        int numbers = datas.getNumber(); //获取数据条数，由用户自行输入

        String[] students = BaseDao.getNames();//获取学生信息表

        String[] webs = BaseDao.getWeb();//获取上网网站表

        String[] times = BaseDao.getTimes();//获取时间表

        for (int x = 0;x < 500;x++) { //学生信息数据长度为500条

            String stuinf = students[x]; //提取出一列数据，形如学号#姓名#年龄#性别

            String[] student = stuinf.split("#");//字符串分隔，将每一项数据提取出来

            if (student[3] == "女"){ //将男女存入不同的list中

                female_students.add(students[0]);

                female_students.add(students[1]);

                female_students.add("女");

            }else {
                male_students.add(students[0]);

                male_students.add(students[1]);

                male_students.add("男");
            }
        }

        int count_num;

        int count_sex;

        int count_time;

        int count_web;

        if(num == "随机"){ count_num = 1;}else count_num = 0;

        if(sex == "随机"){count_sex= 1;}else count_sex = 0;

        if(timeslice == "随机"){
            count_time = 1;
            hours = "0";
        }else {

            count_time = 0;

            String[] time_split = timeslice.split("~");

            String[] hour = time_split[0].split(":");

            hours = hour[0]; //存储时间
        }

        if(web_name == "随机"){count_web = 1;}else count_web = 0;

        int sum_count = count_num+count_sex+count_time+count_web;


        int i = 0;

        File f = new File("D:\\productDouble"); //写入文件

        if (f.exists()) {

            f.delete();

        }

        FileOutputStream fos = new FileOutputStream(f);

        OutputStreamWriter osq = new OutputStreamWriter(fos);

        BufferedWriter bfw = new BufferedWriter(osq);

        switch (sum_count) {

            case 0: //所有信息均为固定的（学号、性别、时间区间、上网网站）

                while (i < numbers){

                    String webtime1 = RandomTime(hours);

                    try {

                        bfw.write(num + "," + name + "," + sex + "," + webtime1 + "\n");

                    } catch (FileNotFoundException e) {

                        e.printStackTrace();

                    } catch (IOException e) {

                        e.printStackTrace();

                    }

                i++;
        }

            case 1: //有一项是随机的，由于学号随机则性别必定随机，所以随机的项为时间区间或网站

                if (count_time == 1){ //时间区间随机

                    while (i<numbers) {

                        //生成随机的时分秒

                        String webtime2 = RandomTime(hours);

                        try {

                            bfw.write(num + "," + name + "," + sex + "," + webtime2 + "\n");

                        } catch (FileNotFoundException e) {

                            e.printStackTrace();

                        } catch (IOException e) {

                            e.printStackTrace();

                        }
                    }

                }else { //随机网站

                    while (i < numbers) {

                        int index = (int) (Math.random() * webs.length);

                        String rand_web1 = webs[index];

                        //生成随机的时分秒

                        String webtime3 = RandomTime(hours);

                        try {

                            bfw.write(num + "," + name + "," + sex + "," + webtime3 + "\n");

                        } catch (FileNotFoundException e) {

                            e.printStackTrace();

                        } catch (IOException e) {

                            e.printStackTrace();

                        }
                    }
                }

            case 2: //有两项是随机的，学号随机（性别/网站/上网区间）或（学号性别固定网站上网区间随机）

                if(count_num == 1){ //学号随机

                        if (count_sex == 1){ //性别随机

                            while (i<numbers){

                                int index = (int) (Math.random() * students.length);

                                String[] rand_students = students[index].split("#");

                                String webtime4 = RandomTime(hours);

                                try {

                                    bfw.write(rand_students[0] + "," + rand_students[1] + "," + rand_students[3] + "," + webtime4 + "\n");

                                } catch (FileNotFoundException e) {

                                    e.printStackTrace();

                                } catch (IOException e) {

                                    e.printStackTrace();

                                }
                            }

                        }

                        else if (count_web == 1){ //网站随机,性别可以为男或女

                            if (sex == "男"){

                                while (i<numbers){

                                    int index = (int) (Math.random() * students.length);
                                }

                            }else {//性别为女

                                while (i<numbers){

                                    int index = (int) (Math.random() * students.length);
                                }

                            }

                        }

                        else{ //上网期间随机


                        }


                }else {//上网区间和上网网站随机



                }

            case 3:



            case 4:
        }

    }

    public String RandomTime(String Starthour){   //生成随机时间方法定义

        //生成随机的分秒

        StringBuffer sb = new StringBuffer(); //使用stringbuffer写入速度更快，节省运行时间

        int minute = (int)(Math.random()*60+00); //生成分钟

        int second = (int)(Math.random()*60+00); //生成秒

        if (Starthour == "0"){

            int hour = (int)(Math.random()*13+00); //生成时

            sb.append(hour); //拼接时间：时分秒


        }else {

            sb.append(Starthour);

        }

        sb.append(":");

        sb.append(minute);

        sb.append(":");

        sb.append(second);

        String webtime = sb.toString();

        return webtime;
    }
}








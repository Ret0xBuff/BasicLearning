public class ClassAndObject {
    public static void main(String[] args){
        //定义类Student
        class Student{
            //类包含的变量
            String name;
            int age;
            float score;

            //类包含的函数
            void say(){
                System.out.println(name + "的年龄是" + age + "，成绩是 " + score);
            }
        }

        //通过类来定义变量，即创建对象
        Student stu1 = new Student();   //必须使用new关键字
        //操作类的成员
        stu1.name = "小明";
        stu1.age = 15;
        stu1.score = 92.5f;
        stu1.say();

        String Test = stu1.name + stu1.age + stu1.score;
        System.out.println(Test);
    }
}

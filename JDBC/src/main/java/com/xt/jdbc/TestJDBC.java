package com.xt.jdbc;

import com.xt.jdbc.dao.DeptDao;
import com.xt.jdbc.dao.EmpDao;
import com.xt.jdbc.dao.impl.DeptDaoImpl;
import com.xt.jdbc.dao.impl.EmpDaoImpl;
import com.xt.jdbc.entity.Dept;
import com.xt.jdbc.entity.Emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class TestJDBC {
    private static Scanner sc = new Scanner(System.in);
    private static EmpDao empDao = new EmpDaoImpl();
    private static DeptDao deptDao = new DeptDaoImpl();
    private static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

    public static void main(String[] args) {
        while (true) {
            showMenu();
            System.out.print("请输入您的选项：");
            int option = sc.nextInt();
            switch(option){
                case 1:
                    findAllEmps();
                    break;
                case 2:
                    findAllDepts();
                    break;
                case 3:
                    deleteEmp();
                    break;
                case 4:
                    updateEmp();
                    break;
                case 5:
                    addEmp();
                    break;
                case 6:
                    addDept();
                    break;
                case 7:
                    exit();
                    break;
                default:
                    System.out.print("选项错误，请重新输入：");
            }

        }
    }

    private static void exit() {
        System.out.println("系统退出中。。。Bye！");
        System.exit(0);
    }

    private static void addDept() {
        System.out.print("请输入部门编号：");
        Integer deptno = sc.nextInt();
        System.out.print("请输入部门名称：");
        String dname = sc.next();
        System.out.print("请输入部门地址：");
        String loc = sc.next();
        deptDao.add(new Dept(deptno, dname, loc));
        System.out.println("部门信息添加成功！");
    }

    private static void addEmp() {
        System.out.print("请输入员工姓名：");
        String ename = sc.next();
        System.out.print("请输入员工职位：");
        String job = sc.next();
        System.out.print("请输入员工领导编号：");
        Integer mgr = sc.nextInt();
        System.out.print("请输入入职日期，格式为 yyyy-MM-dd：");
        String date = sc.next();
        Date hiredate = null;
        try {
            hiredate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("请输入薪资：");
        Double sal = sc.nextDouble();
        System.out.print("请输入津贴：");
        Double comm = sc.nextDouble();
        System.out.print("请输入部门编号：");
        Integer deptno = sc.nextInt();
        empDao.add(new Emp(null, ename, job, mgr, hiredate, sal, comm, deptno));
        System.out.println("员工信息添加成功！");
    }

    private static void updateEmp() {
        System.out.print("请输入要修改的员工编号：");
        Integer empno = sc.nextInt();
        Emp emp = empDao.findById(empno);
        System.out.println("该员工信息如下：");
        System.out.println(emp);
        System.out.println("---------请录入修改信息-----------");
        System.out.print("请输入员工姓名：");
        String ename = sc.next();
        System.out.print("请输入员工职位：");
        String job = sc.next();
        System.out.print("请输入员工领导编号：");
        Integer mgr = sc.nextInt();
        System.out.print("请输入入职日期，格式为 yyyy-MM-dd：");
        String date = sc.next();
        Date hiredate = null;
        try {
            hiredate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("请输入薪资：");
        Double sal = sc.nextDouble();
        System.out.print("请输入津贴：");
        Double comm = sc.nextDouble();
        System.out.print("请输入部门编号：");
        Integer deptno = sc.nextInt();
        empDao.update(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno));
        System.out.println("员工信息修改成功");
    }

    private static void deleteEmp() {
        System.out.print("请输入要删除的员工编号：");
        Integer empno = sc.nextInt();
        empDao.deleteById(empno);
        System.out.println("删除成功！");
    }

    private static void findAllDepts() {
        List<Dept> list = deptDao.findList();
        list.forEach(System.out::println);
    }

    private static void findAllEmps() {
        List<Emp> list = empDao.findList();
        list.forEach(System.out::println);
    }

    private static void showMenu() {
        System.out.println("-------------员工管理系统---------------");
        System.out.println("\t\t\t * 1. 查看所有员工信息");
        System.out.println("\t\t\t * 2. 查看所有部门信息");
        System.out.println("\t\t\t * 3. 根据工号删除员工信息");
        System.out.println("\t\t\t * 4. 根据工号修改员工信息");
        System.out.println("\t\t\t * 5. 增加员工信息");
        System.out.println("\t\t\t * 6. 增加部门信息");
        System.out.println("\t\t\t * 7. 退出");
        System.out.println("---------------------------------------");
    }
}

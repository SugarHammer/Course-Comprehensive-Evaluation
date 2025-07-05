package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yxb.teaching_assessment.biz.entity.Student;
import com.yxb.teaching_assessment.biz.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public Student findByStudentNo(String username) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("studentno",username);
        return studentMapper.selectOne(queryWrapper);
    }

    /**
     * 查找全部
     * @return
     */
   public List<Student> StudentFindAll(){
        return studentMapper.selectList(null);
   }

    /**
     * 增加学生
     * @param student
     * @return
     */
    public  int save(Student student){
        return  studentMapper.insert(student);
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public int update(Student student){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("studentid",student.getStudentid());
        return  studentMapper.update(student,queryWrapper);
    }

    /**
     * 根据id查找学生信息
     * @param studentid
     * @return
     */
    public Student findById(String studentid){
    QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
    queryWrapper.eq("studentid",studentid);
    return studentMapper.selectOne(queryWrapper);
    }

    /**
     * 根据学生姓名查找
     * @param studentname
     * @return
     */
    public List<Student> findLikeBy(String  studentname){
        QueryWrapper<Student> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("studentname",studentname);
        return  studentMapper.selectList(queryWrapper);
    }

    /**
     * 根据id删除
     * @param studentno
     * @return
     */
    public int deleteid(String  studentid){
       Student student =new Student();
       student.setStudentid(Integer.valueOf(studentid));
        student.setIsDelete(1);
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("studentid",student.getStudentid());
        return studentMapper.update(student,queryWrapper);



    }

    /**
     *
     * @param page
     * @return
     */
    public IPage<Student> findList(int page,int limit){
    Integer count =studentMapper.selectCount(new QueryWrapper<Student>());
        IPage<Student> StIPage=new Page<Student>(page,limit,count);
        IPage<Student> list=studentMapper.selectPage(StIPage,new QueryWrapper<Student>());
        return  list;
    }


    public List<Student> findById1(String studentid){
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("studentid",studentid);
        return studentMapper.selectList(queryWrapper);
    }

    public List<Map> listPage(int page, int limit) {
        page=(page-1)*limit;
        return  studentMapper.listPage(page,limit);
    }

    public List<Map> ListLike(String studentname){
        return  studentMapper.ListLike(studentname);
    }
}

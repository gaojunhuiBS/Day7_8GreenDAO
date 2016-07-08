package com.gaojunhui.day7_8greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gaojunhui.dao.DaoMaster;
import com.gaojunhui.dao.DaoSession;
import com.gaojunhui.dao.student;
import com.gaojunhui.dao.studentDao;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.bt_insert)
    Button btInsert;
    @InjectView(R.id.bt_delete)
    Button btDelete;
    @InjectView(R.id.bt_gai)
    Button btGai;
    @InjectView(R.id.bt_updata)
    Button btUpdata;
    private com.gaojunhui.dao.studentDao studentDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        //创建数据库
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(getApplicationContext(),
                "Text.DB",null);
        //得到数据库的操作类
        DaoMaster master=new DaoMaster(helper.getWritableDatabase());
        //得到数据库操作的会话层
        DaoSession session=master.newSession();
        //得到操作表的DAO
        studentDao=session.getStudentDao();

    }

    @OnClick({R.id.bt_insert, R.id.bt_delete, R.id.bt_gai, R.id.bt_updata})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_insert:
              student student=new student();
                student.setName("zhangsan");
                student.setAge(20);
                student.setSex("男");
                studentDao.insert(student);
                break;
            case R.id.bt_delete:
                studentDao.deleteByKey((long) 1);
                break;
            case R.id.bt_gai://修改
                student student1=new student();
                student1.setName("lisi");
                student1.setAge(10);
                student1.setSex("女");
                student1.setId((long) 5);//修改id为5的数据列
                studentDao.update(student1);
                break;
            case R.id.bt_updata://查询
                List<student> list= studentDao.loadAll();
                for (student student2:list){
                    Log.i("-----", "o-------- "+student2.getName()+student2.getId());
                }

                break;
        }
    }
}

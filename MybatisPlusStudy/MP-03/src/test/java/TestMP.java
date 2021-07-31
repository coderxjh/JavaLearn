import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author simba@onlying.cn
 * @date 2021/5/21 20:04
 */
public class TestMP {

    @Test
    public void testGenerator() {
        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setActiveRecord(true)//是否支持AR模式
                .setAuthor("肖江辉")//作者
                .setOutputDir(projectPath + "/src/main/java")//生成路径
                .setFileOverride(true)//文件覆盖
                .setIdType(IdType.AUTO)//主键策略
                .setServiceName("%sService") //设置生成的service接口的名字的首字母是否为I
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL) //设置数据库类型
                .setUrl("jdbc:mysql://localhost:3306/mp?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimeZone=UTC")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("123456");

        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true) //全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略:使用下划线
                .setColumnNaming(NamingStrategy.underline_to_camel)//数据库表字段映射到实体的命名策略：使用下划线
                .setTablePrefix("tbl_") //表名前缀
                .setInclude("tbl_employee"); //生成的表
        //4.包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.xiao.mp")
                .setEntity("pojo")
                .setController("controller")
                .setService("service")
                .setMapper("mapper")
                .setXml("mapper");
        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setStrategy(strategyConfig);
        //6.执行
        autoGenerator.execute();
    }
}
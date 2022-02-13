package bhavna.JDBCProj;


import com.bhavna.empdeptimpli.EmpDeptServiceImpli;
import com.bhavna.empdeptinterface.EmpDeptServiceInterface;

/**
 * Hello world!
 *
 */
/**
 * *
 * @author Mallikarjuna.Katkam
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EmpDeptServiceInterface edsi=new EmpDeptServiceImpli();
    	edsi.chooseYourOption();
    }
}



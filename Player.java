
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;

@DatabaseTable(tableName = "player")
public class Player
{   
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String Name;
    
    @DatabaseField
    private double dinheiro;
    
    @DatabaseField
    private int lvl;
        
    @DatabaseField
    private int hp;
    
    public String getName(){
        return this.Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public double getDinheiro(){
        return this.dinheiro;
    }
    public void setDinheiro(double dinheiro){
        this.dinheiro = dinheiro;
    }
    
    public int getLvl(){
        return this.lvl;
    }
    public void setLvl(int lvl){
        this.lvl = lvl;
    }
    
    public int getHp(){
        return this.hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }

}//End class

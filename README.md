# Persistência de Dados com ORM e CRUD

## Descrição da Classe Escolhida e Implementação

A classe escolhida para esta implementação é a `Player`, que atua como o modelo de dados principal para o sistema de gerenciamento de jogadores utilizando ORM (*Object-Relational Mapping*) através da biblioteca ORMLite.

A implementação faz uso de anotações mapeadas para integrar diretamente a classe a uma tabela relacional no banco de dados:

* **`@DatabaseTable(tableName = "player")`**: Mapeia a classe para uma tabela correspondente no banco de dados chamada "player".
* **`@DatabaseField(generatedId = true)`**: Configura o atributo `id` como chave primária auto-incrementada gerada automaticamente pelo banco.
* **Atributos de Estado (`Name`, `dinheiro`, `lvl` e `hp`)**: Representam as colunas da tabela encarregadas de armazenar as informações vitais do personagem, viabilizando operações completas de CRUD (*Create, Read, Update, Delete*) de forma automatizada pelo mapeamento objeto-relacional.

## Código Fonte (`Player.java`)

```java
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
}
```

### Comprovação das Operações CRUD

#### Foto #1: Estado Inicial (Antes da Persistência)
Como se pode observar na imagem apresentada, a instância `player1` foi criada e preenchida com os atributos iniciais (`Name`: "Ichigo", `dinheiro`: 2.23, `lvl`: 200, `hp`: 25). É possível inferir que o registo **ainda não está salvo no banco de dados**, pois o campo `id` exibe o valor `0`, indicando que o objeto existe apenas de forma volátil na memória RAM e ainda não passou pelo mapeamento de inserção do ORM.

<img width="485" height="287" alt="image" src="https://github.com/user-attachments/assets/62ebe963-6f07-44a1-a379-f1af0ae35435" />

---

#### Foto #2: Operação de Create (Inserção)
Como se pode observar na imagem apresentada, após a execução do método de salvamento do CRUD, o estado da instância `player1` foi atualizado. O campo `id` agora exibe o valor `2`, o que comprova que o registo foi inserido com sucesso na tabela do banco de dados SQLite e o ORMLite atribuiu o identificador único gerado automaticamente (`generatedId = true`) de volta ao objeto.

<img width="483" height="279" alt="image" src="https://github.com/user-attachments/assets/b74dc946-84cd-4d97-aeec-1000b6884085" />


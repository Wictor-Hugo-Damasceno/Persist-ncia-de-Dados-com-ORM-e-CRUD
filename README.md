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
#### Estado Inicial
Como se pode observar na imagem apresentada, a instância `player1` foi criada e preenchida com os atributos iniciais (`Name`: "Ichigo", `dinheiro`: 2.23, `lvl`: 200, `hp`: 25). É possível inferir que o registo **ainda não está salvo no banco de dados**, pois o campo `id` exibe o valor `0`, indicando que o objeto existe apenas de forma volátil na memória RAM e ainda não passou pelo mapeamento de inserção do ORM.

<img width="485" height="287" alt="image" src="https://github.com/user-attachments/assets/62ebe963-6f07-44a1-a379-f1af0ae35435" />

---

#### Operação de Create
Como se pode observar na imagem apresentada, após a execução do método de salvamento do CRUD, o estado da instância `player1` foi atualizado. O campo `id` agora exibe o valor `2`, o que comprova que o registo foi inserido com sucesso na tabela do banco de dados SQLite e o ORMLite atribuiu o identificador único gerado automaticamente (`generatedId = true`) de volta ao objeto.

<img width="483" height="279" alt="image" src="https://github.com/user-attachments/assets/b74dc946-84cd-4d97-aeec-1000b6884085" />

---

#### Operação de Read (Consulta e Persistência)
Como se pode observar na imagem apresentada, após fechar o ambiente de desenvolvimento (BlueJ) e reabri-lo, realizou-se a busca por um ID previamente gravado no banco de dados. O sistema recuperou com sucesso os dados associados ao registo (`id`: 1, `Name`: "Aizen", `dinheiro`: 52.52, `lvl`: 24, `hp`: 202), o que comprova a persistência efetiva e duradoura dos dados através do ORMLite e SQLite mesmo após o encerramento da aplicação.

<img width="622" height="332" alt="image" src="https://github.com/user-attachments/assets/636324ef-ada6-43c1-ac49-f246f5d87619" />

---

#### Operação de Update 
Como se pode observar na imagem apresentada logo abaixo, o registo existente com o `id`: 2 foi modificado através da operação de atualização do CRUD. Os atributos de `dinheiro` (que passou de `2.23` para `2000.0`) e de `hp` (que passou de `25` para `265`) foram alterados com sucesso e refletidos na base de dados.

<img width="561" height="291" alt="image" src="https://github.com/user-attachments/assets/de3e953e-a693-4677-93cd-9141f7fa59a9" />

---

#### Operação de Delete 
Como se pode observar na imagem apresentada logo abaixo, após a execução da operação de exclusão do registo com o `id`: 2, tentou-se carregar novamente esse mesmo ID através do método `loadFromId(2)`. O resultado retornado foi `null`, o que comprova que o registo foi efetivamente removido da base de dados.

<img width="375" height="242" alt="image" src="https://github.com/user-attachments/assets/119a73b9-8678-4b5a-8868-454ea90797aa" />

---

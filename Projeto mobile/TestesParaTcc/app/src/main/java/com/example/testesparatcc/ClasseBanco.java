package com.example.testesparatcc;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.testesparatcc.cliente.CadastroCliente;
import com.example.testesparatcc.cliente.ListaPrestadores;
import com.example.testesparatcc.cliente.Prestador;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ClasseBanco extends SQLiteOpenHelper {

    public static String SetNomeCliente;
    public static String SetEmailCliente;
    public SQLiteDatabase banco = null;
    public SQLiteDatabase banco2 = null;
    public SQLiteDatabase banco3 = null;
    public SQLiteDatabase banco4 = null;
    private static String NOME_DO_BANCO="TccMobile";
    public Cursor cursor;
    public Cursor cursor2;
    String output = "";
    String count = "";
    int deleteServc;
    Context context;
    SQLiteDatabase db;

    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageInByte;

    public ClasseBanco(Context context) {
        super(context, NOME_DO_BANCO, null, 1);
        //db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("CREATE TABLE IF NOT EXISTS PrestServ8(id INTEGER PRIMARY KEY AUTOINCREMENT , nome TEXT, senha TEXT,dtNasc TEXT,endereco TEXT, numero INTEGER, complemento TEXT, cpf TEXT, telefone TEXT, email TEXT, tipo_serv TEXT,plano TEXT ,prestImg BLOB)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ NOME_DO_BANCO);
        onCreate(db);
    }

    public boolean criar_tabela(Context cx)
    {
        try
        {
            String sql = "CREATE TABLE IF NOT EXISTS PrestServ9(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    "nome TEXT, " +
                    "senha TEXT," +
                    "dtNasc TEXT," +
                    "endereco TEXT, " +
                    "numero INTEGER, " +
                    "complemento TEXT, " +
                    "cpf TEXT, " +
                    "telefone TEXT, " +
                    "email TEXT, " +
                    "tipo_serv TEXT," +
                    "prestImg BLOB, " +
                    "id_plano INTEGER," +
                    "FOREIGN KEY (id_plano) REFERENCES Planos(id))";
            String planos = "CREATE TABLE IF NOT EXISTS Planos(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, preco TEXT)";
            String usuario = "CREATE TABLE IF NOT EXISTS Usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, nome_usu TEXT, senha TEXT, dtNasc TEXT, endereco TEXT, numero INTEGER, complemento TEXT, cpf INTEGER, telefone TEXT, email TEXT)";
            String servico = "CREATE TABLE IF NOT EXISTS Servico(" +
                    "id_servico INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "id_prestador INTEGER, " +
                    "id_cliente INTEGER, " +
                    "avaliacao INTEGER, " +
                    "status_servico TEXT, "+
                    "FOREIGN KEY (id_prestador) REFERENCES PrestServ9(id), " +
                    "FOREIGN KEY (id_cliente) REFERENCES Usuario(id))";


            //não sei se é preciso criar varios "banco", tentei usar apenas um e não funcionou, então criei um para cada tabela.
            banco = this.getReadableDatabase();
            banco.execSQL(sql);
            banco.close();

            banco2 = this.getReadableDatabase();
            banco2.execSQL(planos);
            banco2.close();

            banco3 = this.getReadableDatabase();
            banco3.execSQL(usuario);
            banco3.close();

            banco4 = this.getReadableDatabase();
            banco4.execSQL(servico);
            banco4.close();

            if (CriarPlanos1() && CriarPlanos2()){
                Log.e("Planos exec:", "Métodos executados");
            }

            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    //
    //INSERTS
    //

    // Cria os planos da aplicação
    public boolean CriarPlanos1(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", 0);
        contentValues.put("nome", "--------");
        contentValues.put("preco", "--------");
        long insert = db.insert("Planos", null, contentValues);
        if (insert > -1){
            Log.e("Planos:","Plano 0 criado com sucesso");
            return true;
        } else {
            Log.e("Planos:", "plano 0 já existe ou erro ao criá-lo");
            return false;
        }

    }

    public boolean CriarPlanos2(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", 1);
        contentValues.put("nome", "Plano premium");
        contentValues.put("preco", "39,90");
        long insert = db.insert("Planos", null, contentValues);
        if (insert > -1){
            Log.e("Planos:","Plano 1 criado com sucesso");
            return true;
        } else {
            Log.e("Planos:", "plano 1 já existe ou erro ao criá-lo");
            return false;
        }
    }

    // Método que cria um novo serviço de acordo com os IDs do cliente e do prestador.
    public boolean CriarServicoByIds(int id_cliente, int id_prestador){
        try {
            SQLiteDatabase objSQLiteDatabase = this.getWritableDatabase();

            if (objSQLiteDatabase != null) {

                ContentValues objContentValues = new ContentValues();
                objContentValues.put("id_servico", parseInt(contar_registros("select count(*) from Servico"))+1);
                objContentValues.put("id_prestador", id_prestador);
                objContentValues.put("id_cliente ", id_cliente);
                objContentValues.put("avaliacao", "Pendente");
                objContentValues.put("status_servico ", "Aguardando");

                long checkIfQueryRuns = objSQLiteDatabase.insert("Servico", null, objContentValues);
                if (checkIfQueryRuns != -1) {

                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    // Método que cria um novo cliente.
    public boolean CadastroCliente(int id, String nome, String senha, String dtNasc, String endereco, int numero, String complemento, int cpf, String telefone, String email) {
        try {
            SQLiteDatabase objSQLiteDatabase = this.getWritableDatabase();

            if (objSQLiteDatabase != null) {

                ContentValues objContentValues = new ContentValues();
                objContentValues.put("id", id);
                objContentValues.put("nome_usu", nome);
                objContentValues.put("senha ", senha);
                objContentValues.put("dtNasc", dtNasc);
                objContentValues.put("endereco", endereco);
                objContentValues.put("numero", numero);
                objContentValues.put("complemento", complemento);
                objContentValues.put("cpf", cpf);
                objContentValues.put("telefone", telefone);
                objContentValues.put("email", email);

                long checkIfQueryRuns = objSQLiteDatabase.insert("usuario", null, objContentValues);
                if (checkIfQueryRuns != -1) {
                    String[] firstname = nome.split(" ");
                    SetNomeCliente = firstname[0];
                    SetEmailCliente = email;
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    // Método que deleta conta de acordo com o ID e a tabela passada.
    public boolean DeletarConta(int id, String tabela){
        try {
            SQLiteDatabase objSQLiteDatabase = this.getWritableDatabase();

            if (objSQLiteDatabase != null) {

                int delete = objSQLiteDatabase.delete(tabela, "id="+id, null);
                if (tabela.equals("PrestServ9")){
                    deleteServc =  objSQLiteDatabase.delete("Servico", "id_prestador="+id,null);
                }

                if (tabela.equals("Usuario")){
                    deleteServc =  objSQLiteDatabase.delete("Servico", "id_cliente="+id,null);
                }

                if (delete > 0 && deleteServc > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    // Método de testes que deleta servicos, não tem uso na aplicação fora testes do desenvolvedor.
    public boolean DeleteAllServices(Context cx){
        try
        {
            banco = cx.openOrCreateDatabase(NOME_DO_BANCO, cx.MODE_PRIVATE, null);

            int delete = banco.delete("servico", "1", null);
            if (delete > 0) {
                return  true;
            } else
                return  false;
        }catch (Exception ex){ return false; }
    }

    //
    //CONTADORES
    //

    // Conta os serviços com status "Aguardando".
    public Integer CountAguardandoServices(int id_prestador, Context cx){
        try
        {

            SQLiteDatabase db = this.getWritableDatabase();

            cursor = db.rawQuery("select count(*) from Servico where id_prestador="+id_prestador+" and status_servico='Aguardando'", null);
            if(cursor.moveToFirst()){
                output = cursor.getString(0);
            }
            if(output.equals(""))
                output = "0";
            return  Integer.valueOf(output);
        }catch (Exception ex){ return 0; }
    }

    // Conta serviços com status "Finalizado".
    public String ContarServicosFeitosById(int id_prestador){
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery("select count(*) from Servico where id_prestador="+id_prestador+" and status_servico='Finalizado'",null);
            if(data.moveToFirst()){
                output = data.getString(0);
            }
            return output;
        }catch (Exception ex){ return ex.toString(); }
    }

    //
    //UPDATES
    //

    // Ao criar um novo serviço, a avaliação do novo serviço é inserida como "Pendente".
    //E ao finalizar o serviço e quando o cliente avalia, a avaliação é atualizada.
    public boolean SetAvaliacaoServico(int id_servico, String avaliacao){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("avaliacao", avaliacao);
        int up = db.update("Servico", contentValues, "id_servico="+id_servico, null);
        if(up>0){
            return true;
        } else
            return false;
    }

    // Se o prestador aceita o serviço, o status atualiza para "Em andamento".
    public boolean AceitarPedidoPrestadorById(int id_servico, Context cx){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status_servico", "Em andamento");
        int up = db.update("Servico", contentValues, "id_servico="+id_servico, null);
        if(up>0){
            return true;
        } else
            return false;
    }

    // Quando o prestador finaliza o serviço, o status atualiza para "Finalizado".
    public boolean FinalizarServicoById(int id_servico){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status_servico", "Finalizado");
        int up = db.update("Servico", contentValues, "id_servico="+id_servico, null);
        if(up>0){
            return true;
        } else
            return false;
    }

    // Se o prestador recusa o serviço, o status atualiza para "Recusado".
    public boolean RecusarServicoById(int id_servico){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status_servico", "Recusado");
        int up = db.update("Servico", contentValues, "id_servico="+id_servico, null);
        if(up>0){
            return true;
        } else
            return false;
    }

    // Se o prestador cancela o serviço, o status atualiza para "Cancelado".
    public boolean CancelarServicoById(int id_servico){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status_servico", "Cancelado");
        int up = db.update("Servico", contentValues, "id_servico="+id_servico, null);
        if(up>0){
            return true;
        } else
            return false;
    }

    //
    //SELECTS
    //

    // Seleciona o nome do cliente pelo ID
    public String getNomeClienteById(int id){
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery("select nome_usu from usuario where id='"+id+"'",null);
            if(data.moveToFirst()){
                output = data.getString(0);
            }
            return output;
        }catch (Exception ex){ return "Error"; }
    }

    // Seleciona o id do cliente pelo email
    public int getIdClienteByEmail(String email){
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery("select id from usuario where email='"+email+"'",null);
            if(data.moveToFirst()){
                output = data.getString(0);
            }
            return parseInt(output);
        }catch (Exception ex){ return 0; }
    }

    // Seleciona o id do prestador pelo email
    public int getIdPrestByEmail(String email){
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery("select id from PrestServ9 where email='"+email+"'",null);
            if(data.moveToFirst()){
                output = data.getString(0);
            }
            return parseInt(output);
        }catch (Exception ex){ return 0; }
    }


    public int GetIdPrestByEmail(String email){
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery("select id from PrestServ9 where email='"+email+"'",null);
            if(data.moveToFirst()){
                output = data.getString(0);
            }
            return parseInt(output);
        }catch (Exception ex){ return 0; }
    }

    // Executa uma query qualquer passada como parâmetro
    public String getData(String query, Context cx)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery(query,null);
            if(data.moveToFirst()){
                output = data.getString(0).toString();
            }
            return output;
        }catch (Exception ex){ return "0"; }
    }


    public Integer SearchForServicesByPrestId(int id_prestador, Context cx){

        try
        {
            banco = cx.openOrCreateDatabase(NOME_DO_BANCO, cx.MODE_PRIVATE, null);
            cursor2 = banco.rawQuery("select count(*) from Servico where id_prestador="+id_prestador+" and status_servico='Aguardando'", null);
            if (cursor2.moveToFirst()) {
                count = cursor2.getString(0);
                if (count.equals(""))
                    count = "0";
            }

            cursor = banco.rawQuery("select id_servico from Servico where id_prestador="+id_prestador+" and status_servico='Aguardando'", null);
            if(cursor.moveToFirst() && !count.equals("0")){
                output = cursor.getString(0);
            }
            if(output.equals(""))
                output = "0";
            return  Integer.valueOf(output);
        }catch (Exception ex){ return 0; }
    }

    // Seleciona os dados do prestador de acordo com a query passada no parâmetro
    public List<String> getPrestadorData(String query){
        List<String> list = new ArrayList<String>();
        try
        {
            SQLiteDatabase objSQLiteDatabase = this.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery(query, null);

            if (cursor.moveToFirst())
            {
                do
                {
                    list.add(cursor.getString(0)+" - "+cursor.getString(1)+" - "+cursor.getString(2)+" - "+cursor.getString(3)+" - "+cursor.getString(4)+" - "+cursor.getString(5));
                    //list.add(cursor.getString(0)+" - "+cursor.getString(1)+" - "+cursor.getString(8)+" - "+cursor.getString(9)+" - "+cursor.getString(11));
                } while (cursor.moveToNext());
            }
            if (cursor != null && !cursor.isClosed())
            {
                cursor.close();
            }
            return list;
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    // Seleciona a lista de serviços de acordo com o ID do prestador passado
    public List<String> getListServices(int id_prestador){
        try
        {
            SQLiteDatabase objSQLiteDatabase = this.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery("select id_servico, id_cliente, nome_usu, endereco, numero,complemento,telefone, email, status_servico  from Servico, Usuario where id_prestador="+id_prestador+" and id=id_cliente", null);
            List<String> list = new ArrayList<String>();

            if (cursor.moveToFirst())
            {
                do
                {
                    list.add(cursor.getString(0)+" - "+cursor.getString(1)+" - "+cursor.getString(2)+" - "+cursor.getString(3)+" - "+cursor.getString(4)+" - "+cursor.getString(5)+" - "+cursor.getString(6)+" - "+cursor.getString(7)+" - "+cursor.getString(8));
                    //list.add(cursor.getString(0)+" - "+cursor.getString(1)+" - "+cursor.getString(8)+" - "+cursor.getString(9)+" - "+cursor.getString(11));
                } while (cursor.moveToNext());
            }


            if (cursor != null && !cursor.isClosed())
            {
                cursor.close();
            }
            return list;
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    public List<Integer> GetPrestadorIds(){
        List<Integer> list = new ArrayList<Integer>();
        try {
            SQLiteDatabase objSQLiteDatabase = this.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery("select id from PrestServ9", null);

            if (cursor.moveToFirst()) {
                do
                {
                    list.add(cursor.getInt(0));

                } while (cursor.moveToNext());

            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Float> GetMediaAvaliacao(List<Integer> id_prest) {
        List<Float> list = new ArrayList<Float>();
        float soma = 0;
        try {
            SQLiteDatabase objSQLiteDatabase = this.getWritableDatabase();

            for (int j = 0; cursor.moveToNext(); j++) {
                cursor = objSQLiteDatabase.rawQuery("select avaliacao from Servico where avaliacao !='Pendente' and id=" + id_prest.get(j), null);
                if (cursor.moveToFirst()) {
                    for (int i = 0; cursor.moveToNext(); i++) {
                        soma += Float.parseFloat(cursor.getString(i));
                    }
                    list.add(soma);

                }
            }


            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }



            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    // Seleciona a lista de serviços pedidos pelo cliente
    public List<String> getClienteListServices(int id_cliente){
        try
        {
            SQLiteDatabase objSQLiteDatabase = this.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery("select id_servico, id_prestador, nome,telefone, status_servico, avaliacao  from Servico, PrestServ9 where id_cliente="+id_cliente+" and id=id_prestador", null);

            List<String> list = new ArrayList<String>();

            if (cursor.moveToFirst())
            {
                do
                {
                    list.add(cursor.getString(0)+" - "+cursor.getString(1)+" - "+cursor.getString(2)+" - "+cursor.getString(3)+" - "+cursor.getString(4)+" - "+cursor.getString(5));

                } while (cursor.moveToNext());
            }


            if (cursor != null && !cursor.isClosed())
            {
                cursor.close();

            }
            return list;
        }
        catch(Exception ex)
        {
            return null;
        }
    }



    public float GetMediaAvaliacao(int id_prestador) {
        List<String> list = new ArrayList<String>();
        try {
            SQLiteDatabase objSQLiteDatabase = this.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery("select avaliacao from Servico where id_prestador=" + id_prestador + " and avaliacao !='Pendente'", null);

            if (cursor.moveToFirst()) {
                for (int i = 0; cursor.moveToNext(); i++) {
                    list.add(cursor.getString(0));
                }

            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            Float[] notas = new Float[list.size()];
            for (int i = 0; i < list.size(); i++) {
                notas[i] = Float.parseFloat(list.get(i));
            }

            float soma = 0;
            for (float n : notas){
                soma = soma + n;
            }

            float media = soma / notas.length;

            return media;
        } catch (Exception ex) {
            return 0;
        }
    }

    //No cadastro do cliente, uma imagem padrão é cadastrada. O cliente pode alterá-la e esse método é utilizado
    public boolean AddImageByEmail(byte[] image, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("prestImg", image);
        int up = db.update("PrestServ9", contentValues, "email="+"'"+email+"'", null);
        if(up>0){
            return true;
        } else
            return false;
    }

    //Na primeira página de cadastro do cliente, o endereço é cadastrado como vazio. O cliente deve alterá-lo nas páginas seguintes
    // e esse método é utilizado
    public boolean AddEnderecoByEmail(String endereco, String complemento, int numero, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("endereco", endereco);
        contentValues.put("numero", numero);
        contentValues.put("complemento", complemento);
        int up = db.update("PrestServ9", contentValues, "email="+"'"+email+"'", null);
        if(up>0){
            return true;
        } else
            return false;

    }

    //Na primeira página de cadastro do cliente, o CPF é cadastrado como vazio. O cliente deve alterá-lo nas páginas seguintes
    // e esse método é utilizado
    public boolean AddRgCpfByEmail(String cpf, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cpf", cpf);
        int up = db.update("PrestServ9", contentValues, "email="+"'"+email+"'", null);
        if(up>0){
            return true;
        } else
            return false;
    }

    //Na primeira página de cadastro do cliente, o tipo de serviço é cadastrado como vazio. O cliente deve alterá-lo nas páginas seguintes
    // e esse método é utilizado
    public boolean AddServicoByEmail(String servico, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tipo_serv", servico);
        int up = db.update("PrestServ9", contentValues, "email="+"'"+email+"'", null);
        if(up>0){
            return true;
        } else
            return false;
    }

    // Método utilizado para alterar o plano do prestador caso ele o contrate.
    public boolean ContratarPlanoById(int id_prest){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_plano", 1);
        int up = db.update("PrestServ9", contentValues, "id="+id_prest+"", null);
        if(up>0){
            return true;
        } else
            return false;
    }

    // Conta registros de acordo a query passada como parâmetro
    public String contar_registros(String sql)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            cursor = db.rawQuery(sql, null);
            if(cursor.moveToFirst()){
                output = cursor.getString(0);
            }
            if (output.equals("")){
                output = "0";
            }

            return output;
        }catch (Exception ex){ return ex.toString(); }
    }

    // Retorna imagem para o menu principal do prestador
    public Bitmap getImagePrestador(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Bitmap bt = null;
        Cursor cursor = db.rawQuery("select prestImg from PrestServ9 where id="+id, null);
        if (cursor.moveToFirst()){
            byte[] img = cursor.getBlob(0);
            bt = BitmapFactory.decodeByteArray(img, 0 , img.length);
        }
        return bt;
    }

    // Retorna lista de imagens dos prestadores
    public List<Bitmap> getImageListPrestadores(String servico){
        SQLiteDatabase db = this.getWritableDatabase();
        List<Bitmap> listaImagens = new ArrayList<Bitmap>();
        Bitmap bt = null;

        Cursor cursor = db.rawQuery("select prestImg from PrestServ9 where tipo_serv='"+servico+"' order by id_plano desc" , null);
        if (cursor.moveToFirst()){
            do {
                byte[] img = cursor.getBlob(0);
                bt = BitmapFactory.decodeByteArray(img, 0 , img.length);
                listaImagens.add(bt);

            } while(cursor.moveToNext());

        }
        return listaImagens;
    }


}





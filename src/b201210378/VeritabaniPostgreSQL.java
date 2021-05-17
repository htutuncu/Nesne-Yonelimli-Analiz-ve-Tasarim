package b201210378;
import java.sql.*;

public class VeritabaniPostgreSQL implements IVeritabaniBaglantisi{

    private final String dbKullaniciAdi = "postgres";
    private final String dbSifre = "samet";


    @Override
    public boolean girisDogrula(Kullanici kullanici) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbAkilliCihaz"
                    ,dbKullaniciAdi
                    ,dbSifre);

            System.out.println("Veritabanina baglandi.");

            String sql = "SELECT *  FROM \"kullanici\" WHERE \"kullaniciAdi\"='" + kullanici.getKullaniciAdi()
                    + "' and \"sifre\"='" + kullanici.getSifre() + "'";


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            connection.close();

            Thread.sleep(500);
            if (!resultSet.next()) { // Veritabanından dönen ResultSet boş ise böyle bir kullanıcı yoktur
                System.out.println("Böyle bir kullanıcı bulunamadı.");
                resultSet.close();
                statement.close();
                return false;
            } else { // ResultSet boş değilse giriş başarılıdır
                System.out.println("Giriş başarılı.");
                resultSet.close();
                statement.close();
                return true;
            }




        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}

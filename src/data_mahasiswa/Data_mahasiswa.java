/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data_mahasiswa;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;

/**
 *
 * @author NITRO_VIKI
 */
public class Data_mahasiswa {

    /**
     * @param args the command line arguments
     */
    //viki
    public static void main(String[] args) {
        
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=l92rv9pma4rine9s1r3bitrdo7")
                .body("{\"token\" : \"ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49\",\r\n\"query\" : \"select * FROM t_mhs_1 WHERE angkatan = 2023 AND deleted = 0 LIMIT 200\"}")
                .asString();
        
        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows !=0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
                String nama = results.getJSONObject(i).getString("mhs_nama");
                System.out.println(nama);
                
            }
        }
        
        System.out.println(results);
    }
    
}

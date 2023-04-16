//Código gerado automaticamente em https://reqbin.com/
//api usada https://stablediffusionapi.com4
//https://web.postman.co/workspace/My-Workspace~d8618bef-b075-4512-8f20-3886d30c7550/request/create?requestId=cfd59904-d526-43d7-bc8d-69763c966e81

//código não sabe lidar com resposta lenta do server (só trata a string resposta p pegar o link)
package TESTE;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextToImg {

    public static void sendRequest() throws Exception {
        URL url = new URL("https://stablediffusionapi.com/api/v3/text2img");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Content-Type", "application/json");

        //key reeserva jnk2KsT2oHamgoSQg5mI4OqpcHHT1JgY57pudxG3Ei0HJE6hlSDOmoBEMP5l
        String data = "{\n  \"key\": \"-chave da api vai aqui-\",\n  " +
                "\"model_id\": \"anything-v3\",\n  " +
                "\"prompt\": \" Cute virtual pet like kirby, anime style, vector, Lineart" + Menu.promptIA +","+ "\",\n  \"negative_prompt\": \"painting, blurry, glitchy, realistic, photo, human, duplicate\",\n  " +
                "\"width\": \"512\",\n  \"height\": \"512\",\n  \"samples\": \"1\",\n  \"num_inference_steps\": \"30\",\n  \"seed\": null,\n  " +
                "\"guidance_scale\": 7.5,\n  \"webhook\": null,\n  \"track_id\": null\n}";

        //output stream pra "salvar" a imagem no sistema.
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);
        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());

        // Lê a string que o server manda como requisição.
        // Concatenar string até a resposta do server parar
        InputStream in = http.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        System.out.println("Response: " + response.toString());

        http.disconnect();

        //Pegar a imagem da URL e baixar -> dps do "output"
        JSONObject jsonResponse = new JSONObject(response.toString());
        String imageUrl = jsonResponse.getJSONArray("output").getString(0);
        downloadImage(imageUrl);
    }

    //download da imagem, esse metodo pega o paramentro imageuRL e joga um Exception
    //caso tenha algum problema. Tem que reescrever o codigo para que lide melhor com as
    //exceçoes, ex: quando o server enviar outra string (algum erro) como resposta.


    private static void downloadImage(String imageUrl) throws Exception {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream("TAMAGOTCHIAV1/src/IMAGENS/output.png"); //complete o path aqui
        //
        byte[] b = new byte[2048];
        int tamanho;
        //
        while ((tamanho = is.read(b)) != -1) {
            os.write(b, 0, tamanho);
        }
        //fechar o output e input stream dps do download.
        is.close();
        os.close();
    }
}
package br.com.tela.services;

import br.com.tela.progress.ProgressServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marildo Cesar 26/11/2020
 */
public class ViaCEPService extends ProgressServiceImpl {
    
    private final int cep;
    
    public ViaCEPService(int cep) {
        this.cep = cep;
    }
    
    @Override
    public void process() {
        try {
            URL url = new URL("http://viacep.com.br/ws/" + String.valueOf(this.cep) + "/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            StringBuilder jsonSb = new StringBuilder();
            
            br.lines().forEach(l -> jsonSb.append(l.trim()));
            
            String json = jsonSb.toString();
            
            Map<String, String> mapa = new HashMap<>();
            
            Matcher matcher = Pattern.compile("\"\\D.*?\": \".*?\"").matcher(json);
            while (matcher.find()) {
                String[] group = matcher.group().split(":");
                mapa.put(group[0].replaceAll("\"", "").trim(), group[1].replaceAll("\"", "").trim());
            }
            
            if (countObservers() > 0) {
                setChanged();
                notifyObservers(mapa);
            }          
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }
    
}

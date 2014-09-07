package servlets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import sendspaceapi.Data.AnonymousFileEntry;
import sendspaceapi.Upload.Anonymous.AnonymousUpload;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Alex_Stuff on 8/7/2014.
 */
@WebServlet("/draw")
public class drawServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<String> contactList = getContactList(req.getParameterMap());

        int contactsAmount = contactList.size();
        String longestString  = findLongestString(contactList);

        Font arialPlain14 = new Font("Arial", Font.PLAIN,14);
        int stringWidth = getStringWidth(longestString,arialPlain14);
        int itemHight = 22;
        int x = 5;
        int y = 16;

        BufferedImage image = new BufferedImage((stringWidth+(x*2)),itemHight*contactsAmount,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0,0,image.getWidth(),image.getHeight());
        graphics.setColor(Color.BLACK);
        graphics.setFont(arialPlain14);

        for(String str : contactList){
            graphics.drawString(str,x,y);
            y+=itemHight;
        }

        File imageFile = new File("tempImage.jpg");
        imageFile.createNewFile();
        ImageIO.write(image, "jpg", imageFile);

        AnonymousUpload upload = new AnonymousUpload("CYYL0EAZAR");
        AnonymousFileEntry uploadedImage = null;
        try {
            uploadedImage = upload.uploadFile(imageFile);
        } catch (Exception e) {
            req.setAttribute("errorMessage",e.getMessage());
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            System.exit(0);
        }finally {
            imageFile.delete();
        }

        Document downloadPage = Jsoup.connect(uploadedImage.downloadURL()).get();
        String directLink = downloadPage.select("#download_button").attr("href");

        req.setAttribute("directLink",directLink);
        req.setAttribute("downloadUrl",uploadedImage.downloadURL());
        req.setAttribute("deleteUrl",uploadedImage.deleteURL());

        getServletContext().getRequestDispatcher("/success.jsp").forward(req, resp);

    }

    //returns string width in pixels
    public int getStringWidth(String str, Font font){
        return new BufferedImage(1024,100,BufferedImage.TYPE_INT_RGB)
                .getGraphics().getFontMetrics(font).stringWidth(str);
    }


    public String findLongestString(ArrayList<String> contactList){

        int maxLenght = 0;
        String longestString = "";

        for(String str : contactList){

            if(str.length()>maxLenght){
                maxLenght = str.length();
                longestString = str;
            }
        }

        return longestString;
    }


    public ArrayList <String> getContactList(Map<String,String[]> parameterMap){
        ArrayList <String> contacts = new ArrayList<String>();

        for(Map.Entry<String,String[]> entry : parameterMap.entrySet()){

            if(!entry.getValue()[0].equals("")){
                contacts.add(entry.getKey() + ": " + entry.getValue()[0]);
            }

        }
        return contacts;
    }
}

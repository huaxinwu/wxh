package com.wxh.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HttpStudy {

    protected Shell     shell;
    private Text        text;
    private static Text text_1;

    /**
     * Launch the application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            HttpStudy window = new HttpStudy();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     * 
     * @return
     */
    protected Object createContents() {
        shell = new Shell();
        shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
        shell.setSize(490, 459);
        shell.setText("随你问");
        shell.setLayout(null);

        text = new Text(shell, SWT.WRAP);
        text.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
        text.setBounds(79, 49, 374, 138);
        // text.setTextLimit(20);

        text_1 = new Text(shell, SWT.WRAP);
        text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
        text_1.setBounds(79, 228, 374, 138);
        text_1.setEditable(false);

        Label lblNewLabel = new Label(shell, SWT.NONE);
        lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
        lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
        lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
        lblNewLabel.setBounds(37, 68, 36, 119);
        lblNewLabel.setText("请\r\n输\r\n入\r\n问\r\n题");

        Label label = new Label(shell, SWT.NONE);
        label.setText("答\r\n案\r\n点\r\n击\r\n获\r\n取");
        label.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
        label.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
        label.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
        label.setBounds(37, 230, 36, 119);

        Button btnNewButton = new Button(shell, SWT.NONE);
        btnNewButton.setBounds(219, 372, 80, 39);
        btnNewButton.setText("请点我");
        btnNewButton.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                String url = "http://www.tuling123.com/openapi/api";
                String key = "2e7e930825c74e13944972bf3f282e4e";
                String userid = "7788";
                String info = text.getText();
                String param = "key=" + key + "&info=" + info + "&userid=" + userid;

                HttpsRunnable runnable = new HttpsRunnable(url, param);
                Thread thread = new Thread(runnable);
                thread.start();

                try {
                    String result = post(HttpsRunnable.path, HttpsRunnable.params);
                    String su = result.substring(22);

                    String[] tempArr = su.split("\"");
                    // String key1 = tempArr[0].trim();
                    String value = tempArr[1].trim();

                    String str = value;
                    text_1.setText(str);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            public String post(String path, String params) throws Exception {
                HttpURLConnection httpConn = null;
                BufferedReader in = null;
                PrintWriter out = null;

                try {
                    URL url = new URL(path);
                    httpConn = (HttpURLConnection) url.openConnection();
                    httpConn.setRequestMethod("POST");
                    httpConn.setDoInput(true);
                    httpConn.setDoOutput(true);

                    // 发送post请求参数
                    out = new PrintWriter(httpConn.getOutputStream());
                    out.println(params);
                    out.flush();

                    // 读取响应
                    if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        StringBuffer content = new StringBuffer();
                        String tempStr = "";
                        in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                        while ((tempStr = in.readLine()) != null) {
                            content.append(tempStr);
                        }
                        return content.toString();
                    } else {
                        throw new Exception("请求出现了问题");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    in.close();
                    out.close();
                    httpConn.disconnect();
                }
                return null;
            }
        });
        return btnNewButton;

    }
}

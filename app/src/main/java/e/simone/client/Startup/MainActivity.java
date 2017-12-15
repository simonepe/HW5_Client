package e.simone.client.Startup;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import e.simone.client.Net.ResultAppender;
import e.simone.client.R;
import e.simone.client.Net.ServerConnection;

public class MainActivity extends Activity implements ResultAppender {

    private Button connectBtn;
    private Button bGuessWord;
    private TextView resField;
    private TextView scoreField;
    private EditText strField;
    private ServerConnection srvConnection;
    private ImageView imgWon;
    private ImageView imgLost;

    private Button bA;
    private Button bB;
    private Button bC;
    private Button bD;
    private Button bE;
    private Button bF;
    private Button bG;
    private Button bH;
    private Button bI;
    private Button bJ;
    private Button bK;
    private Button bL;
    private Button bM;
    private Button bN;
    private Button bO;
    private Button bP;
    private Button bQ;
    private Button bR;
    private Button bS;
    private Button bT;
    private Button bU;
    private Button bV;
    private Button bW;
    private Button bX;
    private Button bY;
    private Button bZ;
    private Button bQuit;
    private Button bNewGame;

    List<Button> buttonList = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI() {
        imgWon = (ImageView) findViewById(R.id.imgWon);
        imgLost = (ImageView) findViewById(R.id.imgLost);
        imgWon.setVisibility(View.GONE);
        imgLost.setVisibility(View.GONE);

        strField = (EditText) findViewById(R.id.guessWord);
        scoreField = (TextView) findViewById(R.id.scoreField);
        resField = (TextView) findViewById(R.id.textView);

          connectBtn = (Button) findViewById(R.id.button2);
          bGuessWord = (Button) findViewById(R.id.guessWordButton);
          bA = (Button) findViewById(R.id.buttonA);
          bB = (Button) findViewById(R.id.buttonB);
          bC = (Button) findViewById(R.id.buttonC);
          bD = (Button) findViewById(R.id.buttonD);
          bE = (Button) findViewById(R.id.buttonE);
          bF = (Button) findViewById(R.id.buttonF);
          bG = (Button) findViewById(R.id.buttonG);
          bH = (Button) findViewById(R.id.buttonH);
          bI = (Button) findViewById(R.id.buttonI);
          bJ = (Button) findViewById(R.id.buttonJ);
          bK = (Button) findViewById(R.id.buttonK);
          bL = (Button) findViewById(R.id.buttonL);
          bM = (Button) findViewById(R.id.buttonM);
          bN = (Button) findViewById(R.id.buttonN);
          bO = (Button) findViewById(R.id.buttonO);
          bP = (Button) findViewById(R.id.buttonP);
          bQ = (Button) findViewById(R.id.buttonQ);
          bR = (Button) findViewById(R.id.buttonR);
          bS = (Button) findViewById(R.id.buttonS);
          bT = (Button) findViewById(R.id.buttonT);
          bU = (Button) findViewById(R.id.buttonU);
          bV = (Button) findViewById(R.id.buttonV);
          bW = (Button) findViewById(R.id.buttonW);
          bX = (Button) findViewById(R.id.buttonX);
          bY = (Button) findViewById(R.id.buttonY);
          bZ = (Button) findViewById(R.id.buttonZ);
          bQuit = (Button) findViewById(R.id.buttonQuit);
          bNewGame = (Button) findViewById(R.id.buttonNewGame);

        buttonList.add(bA);
        buttonList.add(bB);
        buttonList.add(bC);
        buttonList.add(bD);
        buttonList.add(bE);
        buttonList.add(bF);
        buttonList.add(bG);
        buttonList.add(bH);
        buttonList.add(bI);
        buttonList.add(bJ);
        buttonList.add(bK);
        buttonList.add(bL);
        buttonList.add(bM);
        buttonList.add(bN);
        buttonList.add(bO);
        buttonList.add(bP);
        buttonList.add(bQ);
        buttonList.add(bR);
        buttonList.add(bS);
        buttonList.add(bT);
        buttonList.add(bU);
        buttonList.add(bV);
        buttonList.add(bW);
        buttonList.add(bX);
        buttonList.add(bY);
        buttonList.add(bZ);
        buttonList.add(bNewGame);
        buttonList.add(bGuessWord);

        disableButtons(buttonList);

        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("CONNECT BTN");
                resField.setText("");
                connectBtn.setEnabled(false);
                new ConnectServer().execute();
            }
        });
        bQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                connectBtn.setEnabled(true);
                try {
                    System.out.println("DISCONNECT TIME");
                    srvConnection.disconnect();
                    finish();
                    System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        bNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("NEWGAME");
                enableButtons(buttonList);
                imgWon.setVisibility(View.GONE);
                imgLost.setVisibility(View.GONE);
            }
        });
       bGuessWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg(strField.getText().toString());
                strField.setText("");
            }
        });
        bA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("A");
                bA.setEnabled(false);
            }
        });
        bB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("B");
                bB.setEnabled(false);
            }
        });
        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("C");
                bC.setEnabled(false);
            }
        });
        bD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("D");
                bD.setEnabled(false);
            }
        });
        bE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("E");
                bE.setEnabled(false);
            }
        });
        bF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("F");
                bF.setEnabled(false);
            }
        });
        bG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("G");
                bG.setEnabled(false);
            }
        });
        bH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("H");
                bH.setEnabled(false);
            }
        });
        bI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("I");
                bI.setEnabled(false);
            }
        });
        bJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("J");
                bJ.setEnabled(false);
            }
        });
        bK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("K");
                bK.setEnabled(false);
            }
        });
        bL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("L");
                bL.setEnabled(false);
            }
        });
        bM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("M");
                bM.setEnabled(false);
            }
        });
        bN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("N");
                bN.setEnabled(false);
            }
        });
        bO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("O");
                bO.setEnabled(false);
            }
        });
        bP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("P");
                bP.setEnabled(false);
            }
        });
        bQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("Q");
                bQ.setEnabled(false);
            }
        });
        bR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("R");
                bR.setEnabled(false);
            }
        });
        bS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("S");
                bS.setEnabled(false);
            }
        });
        bT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("T");
                bT.setEnabled(false);
            }
        });
        bU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("U");
                bU.setEnabled(false);
            }
        });
        bV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("V");
                bV.setEnabled(false);
            }
        });
        bW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("W");
                bW.setEnabled(false);
            }
        });
        bX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("X");
                bX.setEnabled(false);
            }
        });
        bY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("Y");
                bY.setEnabled(false);
            }
        });
        bZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resField.setText("");
                srvConnection.sendMsg("Z");
                bZ.setEnabled(false);
            }
        });
}

    @Override
    public void showResult(final String result) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resField.append(result);
                resField.append("\n");
            }
        });

    }

    @Override
    public void won(final String score){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imgWon.setVisibility(View.VISIBLE);
                scoreField.setText(score);
                resField.setText("YOU WON!!! You get to live another day!");
                disableButtons(buttonList);
                bNewGame.setEnabled(true);
            }
        });
    }

    @Override
    public void lost(final String score, final String searchedWord){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imgLost.setVisibility(View.VISIBLE);
                scoreField.setText(score);
                resField.setText("RIP! " + searchedWord);
                disableButtons(buttonList);
                bNewGame.setEnabled(true);
            }
        });

    }

    private void disableButtons(List<Button> buttonList){
        for (Button b : buttonList){
            b.setEnabled(false);
        }
    }

    private void enableButtons(List<Button> buttonList){
        for (Button b : buttonList){
            b.setEnabled(true);
        }
    }

    private class ConnectServer extends AsyncTask<Void, Void, ServerConnection> {
        @Override
        protected ServerConnection doInBackground(Void... _) {
            String srv_host = "192.168.10.233";
            Integer srv_port = 3333;
            ServerConnection srvConnection = new ServerConnection(MainActivity.this, srv_host, srv_port);
            srvConnection.connect();
            srvConnection.sendMsg("NEWGAME");
            return srvConnection;
        }

        @Override
        protected void onPostExecute(ServerConnection srvConnection) {
            //resField.setVisibility(View.VISIBLE);
            enableButtons(buttonList);
            MainActivity.this.srvConnection = srvConnection;
            new Thread(srvConnection).start();
        }
    }

}

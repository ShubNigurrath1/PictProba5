package com.example.pictproba2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //public static int i=0;
    ////////////////////////////////////////////////////////////////////////////////////////////
    //07.08.2022 В общем  создал класс Дата и в нем метод гетНум,идея такая,чтобы метод перебирал мой
    //массив ,состоящий из ИмэйджВиев ,и выдавал номер первого пустого элемента массива.
    //Таким образом я смогу последовательно заполнять нажатием кнопки мой массив из ИмэйджВиев
    //собственно нужной мне картинкой
 ///////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Создаём экземпляр нашего класса экран2 ради его метода,который возвращает нам массив из объектов текстВиев
        Ekran myekran=new Ekran();
        ImageView iuu[]= myekran.getDisp();
        //Устанавливани в каждый элемент массива значение содержимого null,так,на всякий случай чтобы при запуске экран был гарантировано пуст))
        iuu[0].setImageDrawable(null);
        iuu[1].setImageDrawable(null);
        iuu[2].setImageDrawable(null);
        iuu[3].setImageDrawable(null);
        iuu[4].setImageDrawable(null);
        iuu[5].setImageDrawable(null);
        iuu[6].setImageDrawable(null);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public  class Ekran {
        //Создаем массив из ссылок на объекты,чтобы потом получать его с помощью метода getDisp,который его возвращает.
        ImageView my1 = findViewById(R.id.imageView);
        ImageView my2 = findViewById(R.id.imageView2);
        ImageView my3 = findViewById(R.id.imageView3);
        ImageView my4 = findViewById(R.id.imageView4);
        ImageView my5 = findViewById(R.id.imageView5);
        ImageView my6 = findViewById(R.id.imageView6);
        ImageView my7 = findViewById(R.id.imageView7);
        ImageView[] display = {my1, my2, my3, my4, my5, my6, my7};

        public ImageView[] getDisp() {
            return display;
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Data{
    private int pos=0;
    private int i=0;
    //Создаем экземпляр класса,в котором есть метод,получающий наш массив виджетов
    Ekran myEkr=new Ekran();
    //Собственно получаем массив виджетов
    ImageView myMass[]=myEkr.getDisp();
   //Получаем индекс первого пустого виджета
    public int getPervPust(){//С помощью этого метода пытаемся получить номер так скажем первого элемента в массиве,который ничего не содержит
        while (i<6){
            if (myMass[i].getDrawable()==null){break; }//выходим из цикла,если текущий виджет ничего не содержит,значит он то что нам нужно
            //если же содержит ,продолжаем увеличивать перменную индекса,вплоть до последнего возможного значения.
            else i++;//соответственно,при выходе из цикла переменная-счетчик прекращает добавлять значение и останавливается на достигнутом.
                     //а именно возвращает индекс самого первого не заполненного виджета.
        }
        return i;
    }
    /////////////////////////////////////////////////////////////////////////////////////
      public int getPoslZap(){// Этот метод возвращает нам индекс последней заполненной ИмэйджВью
          while (pos<7) {
              if(myMass[pos].getDrawable()!=null)pos++;//Проверяем текущий виджет,если заполнен,добавляем счетчик
              else break;//если пуст,выходим из цикла
          }
          return pos-1;//минусуем переменную на один,так как она по сути возвращает нам позицию первого пустого виджета.
      }                //возникает вопрос,а зачем нам этот метод,если есть метод getPervPust,который возвращает тот же индекс? Ответ станет виден,если
}                      //мы заполним все виджеты и попробуем применить getPervPust вместо getPoslZap))
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public class Identor {//Создаем объект битмап для каждой картинки из ресурсов
        Bitmap odin=BitmapFactory.decodeResource(getResources(),R.drawable.odin);
        Bitmap dva=BitmapFactory.decodeResource(getResources(),R.drawable.dva);
        Bitmap tri=BitmapFactory.decodeResource(getResources(),R.drawable.tri);
        Bitmap chet=BitmapFactory.decodeResource(getResources(),R.drawable.chetire);
        Bitmap pyat=BitmapFactory.decodeResource(getResources(),R.drawable.pyat);
        Bitmap shest=BitmapFactory.decodeResource(getResources(),R.drawable.shest);
        Bitmap sem=BitmapFactory.decodeResource(getResources(),R.drawable.sem);
        Bitmap vosem=BitmapFactory.decodeResource(getResources(),R.drawable.vosem);
        Bitmap devat=BitmapFactory.decodeResource(getResources(),R.drawable.devatt);
        Bitmap nol=BitmapFactory.decodeResource(getResources(),R.drawable.nolll);
        //сооздаем массив символов,это нужно,чтобы помещать в него символы ,соответствующие картинке битмап
        char symbols[]=new char[10];
        Ekran ekran=new Ekran();
        ImageView mydisp[]=ekran.getDisp();
        int p=0;

        public String znach(){//метод сначала заполняет массив символов соответствующимим значениями,затем помещает массив
            while (p<7){      //в строку,и,соответсвенно в итоге возвращает эту строку

                if ((BitmapDrawable)mydisp[p].getDrawable()==null)break;
//создаем текущий битмап последовательно для содержимого каждого элемента массива из имэйджвиев
                Bitmap tekBm=((BitmapDrawable)mydisp[p].getDrawable()).getBitmap();
//Для того,чтобы сравнить наши битмапы,используем метод sameAs(),метод equals почему то не работает
                if (tekBm.sameAs(odin)) symbols[p]='1';
                else if (tekBm.sameAs(dva)) symbols[p]='2';
                else if (tekBm.sameAs(tri)) symbols[p]='3';
                else if (tekBm.sameAs(chet)) symbols[p]='4';
                else if (tekBm.sameAs(pyat)) symbols[p]='5';
                else if (tekBm.sameAs(shest)) symbols[p]='6';
                else if (tekBm.sameAs(sem)) symbols[p]='7';
                else if (tekBm.sameAs(vosem)) symbols[p]='8';
                else if (tekBm.sameAs(devat)) symbols[p]='9';
                else if (tekBm.sameAs(nol)) symbols[p]='0';
                p++;
            }

            String b=new String(symbols);

            return b;
        }


    }

public void MyClick(View view){
Identor id=new Identor();
Ekran myekran=new Ekran();
Data mydat=new Data();
ImageView iuu[]= myekran.getDisp();
if (iuu[6].getDrawable()!=null)return;//чтобы не было замены последней цифры на экране калькулятора при нажатии ,если экран полностью заполнен
  iuu[mydat.getPervPust()].setImageBitmap(id.odin);


}
public void MyClick2(View view){
Identor id=new Identor();
        //Создаем объект класса myekran2
        Ekran myekran=new Ekran();
        //создаем массив иуу которому присваиваем значение с помощью метода нашего созданного объекта
        ImageView iuu[]=myekran.getDisp();
        Data mydat2 =new Data();
    if (iuu[6].getDrawable()!=null)return;//чтобы не было замены последней цифры на экране калькулятора при нажатии ,если экран полностью заполнен
    iuu[mydat2.getPervPust()].setImageBitmap(id.dva);

}
public  void MyClick3(View view){
    Identor id=new Identor();
    //Создаем объект класса myekran2
    Ekran myekran=new Ekran();
    //создаем массив иуу которому присваиваем значение с помощью метода нашего созданного объекта
    ImageView iuu[]=myekran.getDisp();
    Data mydat2 =new Data();
    if (iuu[6].getDrawable()!=null)return;//чтобы не было замены последней цифры на экране калькулятора при нажатии ,если экран полностью заполнен
    iuu[mydat2.getPervPust()].setImageBitmap(id.tri);

}
public void MyClick4(View view){
    Identor id=new Identor();
    //Создаем объект класса myekran2
    Ekran myekran=new Ekran();
    //создаем массив иуу которому присваиваем значение с помощью метода нашего созданного объекта
    ImageView iuu[]=myekran.getDisp();
    Data mydat2 =new Data();
    if (iuu[6].getDrawable()!=null)return;//чтобы не было замены последней цифры на экране калькулятора при нажатии ,если экран полностью заполнен
    iuu[mydat2.getPervPust()].setImageBitmap(id.chet);

}
public void MyClick5(View view){
    Identor id=new Identor();
    //Создаем объект класса myekran2
    Ekran myekran=new Ekran();
    //создаем массив иуу которому присваиваем значение с помощью метода нашего созданного объекта
    ImageView iuu[]=myekran.getDisp();
    Data mydat2 =new Data();
    if (iuu[6].getDrawable()!=null)return;//чтобы не было замены последней цифры на экране калькулятора при нажатии ,если экран полностью заполнен
    iuu[mydat2.getPervPust()].setImageBitmap(id.pyat);

}
public void MyClick6(View view){
    Identor id=new Identor();
    //Создаем объект класса myekran2
    Ekran myekran=new Ekran();
    //создаем массив иуу которому присваиваем значение с помощью метода нашего созданного объекта
    ImageView iuu[]=myekran.getDisp();
    Data mydat2 =new Data();
    if (iuu[6].getDrawable()!=null)return;//чтобы не было замены последней цифры на экране калькулятора при нажатии ,если экран полностью заполнен
    iuu[mydat2.getPervPust()].setImageBitmap(id.shest);

}
public void MyClick7(View view){
    Identor id=new Identor();
    //Создаем объект класса myekran2
    Ekran myekran=new Ekran();
    //создаем массив иуу которому присваиваем значение с помощью метода нашего созданного объекта
    ImageView iuu[]=myekran.getDisp();
    Data mydat2 =new Data();
    if (iuu[6].getDrawable()!=null)return;//чтобы не было замены последней цифры на экране калькулятора при нажатии ,если экран полностью заполнен
    iuu[mydat2.getPervPust()].setImageBitmap(id.sem);

}
public void MyClick8(View view){
    Identor id=new Identor();
    //Создаем объект класса myekran2
    Ekran myekran=new Ekran();
    //создаем массив иуу которому присваиваем значение с помощью метода нашего созданного объекта
    ImageView iuu[]=myekran.getDisp();
    Data mydat2 =new Data();
    if (iuu[6].getDrawable()!=null)return;//чтобы не было замены последней цифры на экране калькулятора при нажатии ,если экран полностью заполнен
    iuu[mydat2.getPervPust()].setImageBitmap(id.vosem);

}
public void MyClick9(View view){
    Identor id=new Identor();
    //Создаем объект класса myekran2
    Ekran myekran=new Ekran();
    //создаем массив иуу которому присваиваем значение с помощью метода нашего созданного объекта
    ImageView iuu[]=myekran.getDisp();
    Data mydat2 =new Data();
    if (iuu[6].getDrawable()!=null)return;//чтобы не было замены последней цифры на экране калькулятора при нажатии ,если экран полностью заполнен
    iuu[mydat2.getPervPust()].setImageBitmap(id.devat);

}
public void MyClick0(View view){
    Identor id=new Identor();
    //Создаем объект класса myekran2
    Ekran myekran=new Ekran();
    //создаем массив иуу которому присваиваем значение с помощью метода нашего созданного объекта
    ImageView iuu[]=myekran.getDisp();
    Data mydat2 =new Data();
    if (iuu[6].getDrawable()!=null)return;//чтобы не было замены последней цифры на экране калькулятора при нажатии ,если экран полностью заполнен
    iuu[mydat2.getPervPust()].setImageBitmap(id.nol);

}
public void MyClickBack(View view){

        Data mydatBack=new Data();
        Ekran myekran=new Ekran();
        if (mydatBack.getPervPust()==0)return;//выходим из процедуры,если у нас пустой экранчик калькулятора,если не выйти,то при нажатии вылетает
        //создаем массив иуу которому присваиваем значение с помощью метода нашего созданного объекта
        ImageView iuu[]=myekran.getDisp();
        iuu[mydatBack.getPoslZap()].setImageDrawable(null);//собственно удаляем значение в последнем заполненном виджете,при нажатии это выглядит как последовательное стирание цифр на экране калькулятора


    }
public void MyClickProv(View view){//Эта процедура получает преобразует значения битмапов в массиве виджетов в строку с идентичными цифрами
    TextView tex=findViewById(R.id.textView2);
    Ekran data=new Ekran();
    Identor id=new Identor();
    String ss=id.znach();
    tex.setText(ss);
}
}
                                 //СТАРЫЕ      КОММЕНТЫ//

//31.07.2022Короче пока идея массива из объектов ImageView до конца не оформлена))Пока ничего не работает и нихрена непонятно
//01.08.2022 В общем ,сегодня выяснил одну интересную вещь,оказывается метод findviewbyid это метод класса Activity
    //именно поэтому я и не мог вот так запросто взять и вызвать его в созданном мною классе...до тех пор,пока не сделал
    //свой класс наследником Activity и после этого процесс пошёл))19.08.2022 это было ошибкой)

    //02.08.2022 Выяснилось еще много интересного))При попытке запустить метод созданного мной класса наследника программа
    //вылетает,причём она вылетает,даже если в процедуре кнопки я создаю просто экземпляр моего класса,даже не вызывая метод.
    //проблему я решил так:создал мой класс прямо внутри класса MainActivity,пока могу сказать ,что при создании объекта
    //и при вызове его метода вылетать перестало.Уже прогресс))

    //05.08.2022 В общем необходимо как то создать методы управления моим массивом объектов,наподобие управления
    //символами в строке,по аналогии с моим калькулятором.С чего начать?Наверное с последовательного заполнения массива
    //одним значением по мере нажатия кнопки...

    //06.08.2022 В общем,инфа к врпрсу о создании метода,который бы показывал,насколько заполнена наша коллекция ИмэйджВиев картинками
    //с изображениями цифр:я так понимаю,что нужно создать метод,в котором бы был цикл последовательно обходящий коллекцию с проверкой
    //каждого элемента на наличие фона(в нашем случае если в виеве установлен фон,значит цифры там естественно нет),таким образом
    //мы получаем подобие метода GetLenght().
    //Так же нам необходимо создать метод для массива ImageView,который был бы подобен методу getText в Textview,чтобы получать массив идентификаторов
    //наших картинок с цифрами.
//18.08.2022 В общем,программа вылетала ,если пыталась создать битмап из нулевого значения,проблема была устранена постановкой условия,
//типа если значение нуль тогда выход из операции либо брейк из цикла.Вроде все так ,буду еще проверять.
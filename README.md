# HurriyetApi
Hürriyet sitesinin apisini kullanarak haber başlık,resim,url ve açıklama kısmını android projesinde kullanma

<h2><b>Giriş</b></h2><br>
Yakın zamanda Hürriyet içeriklere ulaşmak isteyen geliştiriciler için api yayınladı. Bu developers api ile belirli kısıtlamalar ile haber, köşe yazısı içeriklerine JSON çıktı olarak ulaşabiliyoruz.

Kullanmadan önce Başlarken adlı dökümanı incelemenizde fayda var.<br>
<a href="https://developers.hurriyet.com.tr/docs/versions/1.0">Hürriyet Başlarken Dökümanı Versiyon 1.0</a><br><br>


<h2><b>Hakkında</b></h2><br>
Android cihazların kullanımı için geliştirilmiştir. JSON çıktı alırken ihtiyaca göre makalelerin;
<li>Başlıkları</li>
<li>Açıklamaları</li>
<li>Makale Url Kısmı</li>
<li>Makale Resim Url Kısmı</li><br>
alınmıştır. Alınan veriler Cardview bileşeni ile gösterilmiştir. 

Hürriyet Developers Api'nin sağladığı imkanlar ile JSON çıktı alma yönteminde değişikler yapılabilir. Örneğin kayıt listelemede sınırlamalar yapılmak istendiğinde $top parametresi kullanılabilir. Diğer kullanım parametreleri için <a href="https://developers.hurriyet.com.tr/docs/versions/1.0#h%C3%BCrriyet-api---odata-kullan%C4%B1m%C4%B1">tıklayınız.</a>



<h2><b>Kullanımı</b></h2>
<li>Config.java dosyasını kendi bilgilerinize göre doldurmalısınız. Api keyinizi ilgili yere yerleştirmeniz gerekmektedir.</li>

<li>Gerekli kütüphaneleri projeye dahil etmelisiniz.</li>

build.gradle(Module:app)<br>

    compile 'com.android.support:appcompat-v7:24.2.0'
    compile 'com.android.support:cardview-v7:24.2.0'
    compile 'com.mcxiaoke.volley:library-aar:1.0.0'
    compile 'com.android.support:design:24.2.0'
    
  
<li>Manifest İzni</li><br>
<code>
android:name="android.permission.INTERNET"
</code>

<h2><b>Ekran Görüntüsü</b></h2>

[![Demo CountPages alpha](https://media.giphy.com/media/xTiN0P1WAF3y2cPyDu/source.gif)](https://www.youtube.com/watch?v=Y3gi-XzieCE)

# Açık Kaynaklı Uygulamalar Üzerinde Otomatik Testler

Bu depo, Github'da popüler 5 farklı açık kaynaklı uygulama için otomatik test senaryolarını içermektedir. Testlerin temel amacı, uygulamaların işlevselliğini, kullanılabilirliğini ve güvenilirliğini değerlendirmektir. Her proje, uçtan uca mobil uygulama testleri için bir dizi araç ve çerçeve kullanılarak geliştirilmiştir.

## Test Edilen Açık Kaynaklı Uygulamalar

1. **uHabits**
    - **Açıklama**: Kullanıcıların alışkanlık oluşturmasını ve sürdürmesini amaçlayan bir alışkanlık takip uygulaması.
    - **Test Edilen Özellikler**: Alışkanlık ekleme, düzenleme ve silme işlemleri.
    - **Uygulama Bağlantısı**: [uHabits GitHub](https://github.com/iSoron/uhabits)

2. **WordPress**
    - **Açıklama**: WordPress sitelerini yönetmek için kullanılan bir mobil uygulama.
    - **Test Edilen Özellikler**: Hesap oluşturma, Google ile giriş yapma ve kullanıcı doğrulama.
    - **Uygulama Bağlantısı**: [WordPress GitHub](https://github.com/wordpress-mobile/WordPress-Android)

3. **Orgzly Revived**
    - **Açıklama**: Kişisel organizasyon için kullanılabilen bir not defteri ve görev yönetimi uygulaması.
    - **Test Edilen Özellikler**: Not defteri oluşturma, düzenleme ve silme işlemleri.
    - **Uygulama Bağlantısı**: [Orgzly GitHub](https://github.com/orgzly/orgzly-android)

4. **DivKit Playground**
    - **Açıklama**: JSON tabanlı UI oluşturma için Yandex tarafından geliştirilmiş bir framework'ü tanıtan demo uygulama.
    - **Test Edilen Özellikler**: JSON giriş, işleme ve UI'de görüntüleme.
    - **Uygulama Bağlantısı**: [DivKit Playground GitHub](https://github.com/divkit/divkit/tree/main/client/android)

5. **Bitwarden**
    - **Açıklama**: Şifre oluşturma ve saklama işlevselliği sağlayan güvenli bir şifre yöneticisi.
    - **Test Edilen Özellikler**: Hesap oluşturma, şifre ipucu doğrulama ve veri ihlali kontrolü.
    - **Uygulama Bağlantısı**: [Bitwarden GitHub](https://github.com/bitwarden/android)

## Kullanılan Araçlar ve Çerçeveler

### Test Çerçeveleri ve Araçları
- **Appium**: Mobil uygulama testlerini otomatikleştirmek için kullanıldı.
- **Appium Server GUI**: Appium testleri için sunucu başlatma ve yönetim aracı olarak kullanıldı.
- **Appium Inspector**: Mobil uygulamalardaki elementleri incelemek ve doğru lokasyonları tespit etmek için kullanıldı.
- **Selenium WebDriver**: Tarayıcı tabanlı otomasyon ve Appium entegrasyonu için kullanıldı.
- **TestNG**: Test senaryolarının düzenlenmesi ve paralel olarak çalıştırılması için kullanıldı.
- **JUnit**: TestNG’ye alternatif bir test çerçevesi olarak kullanıldı.

### Yardımcı Araçlar
- **APK Info**: Uygulama paket adı ve aktivite isimlerini öğrenmek için kullanıldı. Bu araç, test senaryolarında kullanılan paket ve aktivite bilgilerinin doğruluğunu sağladı.

### Geliştirme Araçları
- **Java**: Test senaryolarını yazmak için kullanılan birincil programlama dili.
- **IntelliJ IDEA**: Geliştirme ortamı olarak tercih edildi.

### Derleme Araçları
- **Maven**: Proje bağımlılıklarını yönetmek ve testlerin derleme sürecini kolaylaştırmak için kullanıldı.
- **Gradle**: Alternatif olarak bazı projelerde kullanılan bir derleme sistemi.

### Cihaz ve Emülatör
- **Android Emulator**: Testlerin sanal bir ortamda çalıştırılması için kullanıldı.
- **Fiziksel Cihazlar**: Gerçek dünyadaki kullanım senaryolarını test etmek için kullanıldı.

### Ekstra Kütüphaneler
- **Apache Commons IO**: Dosya işlemlerini kolaylaştırmak için kullanıldı.
- **JSON-Simple**: JSON verilerinin ayrıştırılması ve doğrulanması için kullanıldı.

## Testleri Çalıştırma

1. Depoyu klonlayın:
   ```bash
   git clone https://github.com/kullaniciadi/projeadi.git

2.[Döküman linki için tıklayın](https://drive.google.com/file/d/185k_DcKyEta7ck-IINA4-lt17C1T5nhF/view?usp=sharing)

 
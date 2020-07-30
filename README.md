
<h3>Описание:</h3>

При запуске приложения, база данных валют и их курсов обновляется  с api ЦБРФ(индентификаторы, коды, названия), http://www.cbr.ru/scripts/XML_daily.asp (дополнительная информация https://cbr.ru/development/sxml/), а так же курсы (привязанные к валюте) на дату запроса.
В данном приложиние имеется регистрация,нужно указать логин, пароль, выбрать роль вашего аккаунта, пройти каптчу.

<p>Каптча сделана при помощи серивса гугл(recaptcha 2).</p>

На выбор пользователю предлаегается 2 роли
<ul>
   <li>Роль для использования конвертатора</li>
   <li>Роль для простого просмотра списка валют</li>
</ul>

В конвертере  есть авторизация по логину и паролю. Пользователь пройдя авторизацию попадает на главный экран, где может выбрать из какой валюты и в какую будет конвертация, указывает количество переводимых средств и нажимает кнопку "Конвертировать". После чего происходит запрос в БД на получение актуального курса на ***текущую дату ***, если данные на текущую дату отсутствуют, необходимо, произвести получение курсов с сайта ЦБ и добавить новые записи в базу данных. Также в конвертере ведётся история произведенных конвертаций с записью в базу данных со ссылкой на курс по которой была произведена конвертаци. Историю можно посмотреть на той же странице конвертера.

Вся страница конвертера ( история и конвертация), работает полностью асинхроно( без обновления страницы)
Тестирование осуществленно при помощи jUnit 5 и фреймворка Mockito.

<h3>Используемые технологии:</h3>

<h2>Backend main:</h2>
<ul>
   <li>Java 13</li>
   <li>Spring framework (spring boot)</li>
   <li>Postgresql</li>
   <li>Hibernate</li>
</ul>

<h2>Backend test:</h2>
<ul>
   <li>Java 13</li>
   <li>jUnit 5</li>
   <li>Mockito</li>
</ul>

 <h2>Frontend:</h2>
<ul>
   <li>Freemarker</li>
   <li>Vue js</li>
   <li>CSS</li>
   <li>Thymeleaf</li>
   <li>Bootstrap</li>
</ul>
  
<h3>Использование</h3>

  <p> На вашем сервере базы данных, создать новую БД с назвавние 'currency', с помощью фреймворка spring data будут созданы таблицы в базе данных.</p>
  <p> В папке проекта установить все Vue.js зависимости с помощью команды "yarn install", а так же запустить сервер разработки фронтэнда с помощью команды "yarn start". И запустить spring приложение.</p>
  <p> Далее перейти на localhost:8089/login, если не произойдет авторедирект вдруг. На данной странице будет кнопка логина и регистрации. После удачного логина произойдет редирект на страницу valute.</p>
  <p> На данной странице пользователю предлагается выбрать исходящую и  получаемую валюту для конвертации. Так же будет доступна таблица c вашей истории, в которой вы так же можете выбрать поиск по исходящим в получаемую валюту в нужную вам дату.</p>

<h3>Интерфейс</h3>

<p><b>Форма конвертирования</b></p>

![Sreen1](https://user-images.githubusercontent.com/48677713/88924546-1a76ea80-d27c-11ea-9d2d-bc38efd08a52.png)


<p><b>Истории и поиска</b></p>
![screen2](https://user-images.githubusercontent.com/48677713/88924537-18ad2700-d27c-11ea-90f8-a2dc7e2ca5c6.png)

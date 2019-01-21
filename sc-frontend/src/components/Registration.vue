<template>
  <div>
    <input type="radio" checked id="toggle--login" name="toggle" class="ghost"/>
    <input type="radio" id="toggle--signup" name="toggle" class="ghost"/>
    <input type="radio" id="toggle--recovery" name="toggle" class="ghost" />

    <img class="logo framed" v-if="" src="./../assets/bkob-logo.png" alt="Bkob logo"/>

<!--TODO Переодрисация после регистрации-->

    <!--LOGIN-->
    <form class="form form--login framed">

      <label  for="toggle--signup" v-show="logError"  class="text text--small text--centered"> <b>Errrroroorororor</b></label>


      <input type="email" placeholder="Email" class="input input--top" v-model="user.email"
      />
      <input type="password" placeholder="Password" class="input" v-model="user.password" />

      <input readonly type="submit" value="Log in" class="input input--submit" @click.prevent="loginUser(); redirectToMain();"/>

      <div>
      <input type="checkbox"  v-model="rememberMe">  <label class="text text--small text--centered">Remember me</label>

      <label  for="toggle--signup" class="text text--small text--centered"> <b style="padding-left:  70px">Sign up</b></label>
      </div>
      <label for="toggle--recovery" class="text text--small text--centered"><b style="padding-left: 100px">Recovery</b></label>

    </form>

    <!--REGISTRATION -->

    <form class="form form--signup framed">

      <transition enter-active-class="animated slideInRight"
                  leave-active-class="animated slideOutDown"
                  mode="out-in">
        <div v-if="!show" key="first">
          <label for="toggle--signup" v-show="signError" class="text text--small text--centered"> <b>Errorrrrr</b></label>
          <div v-for="(item, index) in info">
            <input
                   type="text"
                   :placeholder="item.placeholder"
                   :type="item.type"
                   :value="item.value"
                   @input="onInput(index, $event.target.value)"
                   :class="controls[index].activated?[item.class,controls[index].error ? 'icon-danger' : 'icon-success']:item.class"
            />

          </div>
          <input readonly value="Sign up" class="input input--submit slider__nuv" :disabled=" done < info.length"
                 @click="show=true">
          <input type="checkbox"  v-model="rememberMe">  <label class="text text--small text--centered">Remember me</label>
          <label for="toggle--login" class="text text--small text--centered"><b style="padding-left: 80px">Log in</b></label>

          <!--<input type="password" placeholder="Password" class="input"  v-model="user.password" />-->
          <!--<input type="password" placeholder="Confirm Password" class="input"  v-model="user.password2" />-->
        </div>

        <div class="wrp" id="app" v-else key="second">
          <div v-show="signError">
            <input type="text" placeholder="Email" class="input input--top" v-model="info[1].value" />
            <input type="text" placeholder="Username" class="input" v-model="info[0].value" />
            <button  class="outline"  @click.prevent="createUser();redirectToLogin();">let's go</button>
          </div>

          <div class="grid slider slider__item">
            <div class="slider__item">

              <!-- Slider -->
              <div class="subitems" >
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Rust')" v-model=" user.languages"
                                            class="option-input checkbox" value="Rust"/>Rust
                </div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Clojure')"
                                            v-model=" user.languages" class="option-input checkbox" value="Clojure"/>Clojure
                </div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Java')" v-model=" user.languages"
                                            class="option-input checkbox" value="Java"/>Java
                </div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('C++')" v-model=" user.languages"
                                            class="option-input checkbox" value="C++"/>C++
                </div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('C#')" v-model=" user.languages" class="option-input checkbox" value="C#"/>C#</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('C')" v-model=" user.languages" class="option-input checkbox" value="C"/>C</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Delphi')" v-model=" user.languages" class="option-input checkbox"  value="Delphi" />Delphi</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Haskell')" v-model=" user.languages" class="option-input checkbox"  value="Haskell"/>Haskell</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Scala')" v-model=" user.languages" class="option-input checkbox"  value="Scala"/>Scala</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Dart')" v-model=" user.languages" class="option-input checkbox"  value="Dart"/>Dart</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Elixir')" v-model=" user.languages" class="option-input checkbox"  value="Elixir"/>Elixir</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Crystal')" v-model=" user.languages" class="option-input checkbox"  value="Crystal"/>Crystal</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Swift')" v-model=" user.languages" class="option-input checkbox"  value="Swift"/>Swift</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Sql')" v-model=" user.languages" class="option-input checkbox"  value="Sql"/>Sql</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Shell')" v-model=" user.languages" class="option-input checkbox"  value="Shell"/>Shell</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Phyton')" v-model=" user.languages" class="option-input checkbox"  value="Phyton"/>Python</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('Ruby')" v-model=" user.languages" class="option-input checkbox"  value="Ruby"/>Ruby</div>
                <div class="content"><input type="checkbox" :disabled="checkboxdone('JavaScript')" v-model=" user.languages" class="option-input checkbox"  value="JavaScript"/>JavaScript</div>
                <div class="content"> <input type="checkbox" :disabled="checkboxdone('Go')" v-model=" user.languages" class="option-input checkbox"  value="Go"/>Go</div>
                <div class="content"> <input type="checkbox" :disabled="checkboxdone('PHP')" v-model=" user.languages" class="option-input checkbox"  value="PHP"/>PHP</div>
                <div class="subsubitems">
                  <div class="styled-select1 yellow rounded">
                    <select  v-model="user.day">
                      <option disabled selected>DAY</option>
                      <option value="01">01</option>
                      <option value="02">02</option>
                      <option value="03">03</option>
                      <option value="04">04</option>
                      <option value="05">05</option>
                      <option value="06">06</option>
                      <option value="07">07</option>
                      <option value="08">08</option>
                      <option value="09">09</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option>
                      <option value="13">13</option>
                      <option value="14">14</option>
                      <option value="15">15</option>
                      <option value="16">16</option>
                      <option value="17">17</option>
                      <option value="18">18</option>
                      <option value="19">19</option>
                      <option value="20">20</option>
                      <option value="21">21</option>
                      <option value="22">22</option>
                      <option value="23">23</option>
                      <option value="24">24</option>
                      <option value="25">25</option>
                      <option value="26">26</option>
                      <option value="27">27</option>
                      <option value="28">28</option>
                      <option value="29">29</option>
                      <option value="30">30</option>
                      <option value="31">31</option>
                    </select>
                  </div>
                  <div class="styled-select2 yellow rounded">
                    <select  v-model="user.month">
                      <option disabled selected>MONTH</option>
                      <option value="January">January</option>
                      <option value="February">February</option>
                      <option value="March">March</option>
                      <option value="April">April</option>
                      <option value="May">May</option>
                      <option value="June">June</option>
                      <option value="July">July</option>
                      <option value="August">August</option>
                      <option value="September">September</option>
                      <option value="October">October</option>
                      <option value="November">November</option>
                      <option value="December">December</option>
                    </select>
                  </div>
                  <div class="styled-select3 yellow rounded">
                    <select v-model="user.year">
                      <option disabled selected>YEAR</option>
                      <option value="2014">2014</option>
                      <option value="2013">2013</option>
                      <option value="2012">2012</option>
                      <option value="2011">2011</option>
                      <option value="2010">2010</option>
                      <option value="2009">2009</option>
                      <option value="2008">2008</option>
                      <option value="2007">2007</option>
                      <option value="2006">2006</option>
                      <option value="2005">2005</option>
                      <option value="2004">2004</option>
                      <option value="2003">2003</option>
                      <option value="2002">2002</option>
                      <option value="2001">2001</option>
                      <option value="2000">2000</option>
                      <option value="1999">1999</option>
                      <option value="1998">1998</option>
                      <option value="1997">1997</option>
                      <option value="1996">1996</option>
                      <option value="1995">1995</option>
                      <option value="1994">1994</option>
                      <option value="1993">1993</option>
                      <option value="1992">1992</option>
                      <option value="1991">1991</option>
                      <option value="1990">1990</option>
                      <option value="1989">1989</option>
                      <option value="1988">1988</option>
                      <option value="1987">1987</option>
                      <option value="1986">1986</option>
                      <option value="1985">1985</option>
                      <option value="1984">1984</option>
                      <option value="1983">1983</option>
                      <option value="1982">1982</option>
                      <option value="1981">1981</option>
                      <option value="1980">1980</option>
                      <option value="1979">1979</option>
                      <option value="1978">1978</option>
                      <option value="1977">1977</option>
                      <option value="1976">1976</option>
                      <option value="1975">1975</option>
                      <option value="1974">1974</option>
                      <option value="1973">1973</option>
                      <option value="1972">1972</option>
                      <option value="1971">1971</option>
                      <option value="1970">1970</option>
                      <option value="1969">1969</option>
                      <option value="1968">1968</option>
                      <option value="1967">1967</option>
                      <option value="1966">1966</option>
                      <option value="1965">1965</option>
                      <option value="1964">1964</option>
                      <option value="1963">1963</option>
                      <option value="1962">1962</option>
                      <option value="1961">1961</option>
                      <option value="1960">1960</option>
                      <option value="1959">1959</option>
                      <option value="1958">1958</option>
                      <option value="1957">1957</option>
                      <option value="1956">1956</option>
                      <option value="1955">1955</option>
                      <option value="1954">1954</option>
                      <option value="1953">1953</option>
                      <option value="1952">1952</option>
                      <option value="1951">1951</option>
                      <option value="1950">1950</option>
                    </select>
                  </div>
                  <div class="styled-select4 green rounded">
                    <select  v-model="user.country">
                      <option disabled selected>COUNTRY</option>
                      <option value="Afghanistan">Afghanistan</option>
                      <option value="Albania">Albania</option>
                      <option value="Algeria">Algeria</option>
                      <option value="American Samoa">American Samoa</option>
                      <option value="Andorra">Andorra</option>
                      <option value="Angola">Angola</option>
                      <option value="Anguilla">Anguilla</option>
                      <option value="Antartica">Antarctica</option>
                      <option value="Antigua and Barbuda">Antigua and Barbuda</option>
                      <option value="Argentina">Argentina</option>
                      <option value="Armenia">Armenia</option>
                      <option value="Aruba">Aruba</option>
                      <option value="Australia">Australia</option>
                      <option value="Austria">Austria</option>
                      <option value="Azerbaijan">Azerbaijan</option>
                      <option value="Bahamas">Bahamas</option>
                      <option value="Bahrain">Bahrain</option>
                      <option value="Bangladesh">Bangladesh</option>
                      <option value="Barbados">Barbados</option>
                      <option value="Belarus">Belarus</option>
                      <option value="Belgium">Belgium</option>
                      <option value="Belize">Belize</option>
                      <option value="Benin">Benin</option>
                      <option value="Bermuda">Bermuda</option>
                      <option value="Bhutan">Bhutan</option>
                      <option value="Bolivia">Bolivia</option>
                      <option value="Bosnia and Herzegowina">Bosnia and Herzegowina</option>
                      <option value="Botswana">Botswana</option>
                      <option value="Bouvet Island">Bouvet Island</option>
                      <option value="Brazil">Brazil</option>
                      <option value="British Indian Ocean Territory">British Indian Ocean Territory</option>
                      <option value="Brunei Darussalam">Brunei Darussalam</option>
                      <option value="Bulgaria">Bulgaria</option>
                      <option value="Burkina Faso">Burkina Faso</option>
                      <option value="Burundi">Burundi</option>
                      <option value="Cambodia">Cambodia</option>
                      <option value="Cameroon">Cameroon</option>
                      <option value="Canada">Canada</option>
                      <option value="Cape Verde">Cape Verde</option>
                      <option value="Cayman Islands">Cayman Islands</option>
                      <option value="Central African Republic">Central African Republic</option>
                      <option value="Chad">Chad</option>
                      <option value="Chile">Chile</option>
                      <option value="China">China</option>
                      <option value="Christmas Island">Christmas Island</option>
                      <option value="Cocos Islands">Cocos (Keeling) Islands</option>
                      <option value="Colombia">Colombia</option>
                      <option value="Comoros">Comoros</option>
                      <option value="Congo">Congo</option>
                      <option value="Congo">Congo, the Democratic Republic of the</option>
                      <option value="Cook Islands">Cook Islands</option>
                      <option value="Costa Rica">Costa Rica</option>
                      <option value="Cota D'Ivoire">Cote d'Ivoire</option>
                      <option value="Croatia">Croatia (Hrvatska)</option>
                      <option value="Cuba">Cuba</option>
                      <option value="Cyprus">Cyprus</option>
                      <option value="Czech Republic">Czech Republic</option>
                      <option value="Denmark">Denmark</option>
                      <option value="Djibouti">Djibouti</option>
                      <option value="Dominica">Dominica</option>
                      <option value="Dominican Republic">Dominican Republic</option>
                      <option value="East Timor">East Timor</option>
                      <option value="Ecuador">Ecuador</option>
                      <option value="Egypt">Egypt</option>
                      <option value="El Salvador">El Salvador</option>
                      <option value="Equatorial Guinea">Equatorial Guinea</option>
                      <option value="Eritrea">Eritrea</option>
                      <option value="Estonia">Estonia</option>
                      <option value="Ethiopia">Ethiopia</option>
                      <option value="Falkland Islands">Falkland Islands (Malvinas)</option>
                      <option value="Faroe Islands">Faroe Islands</option>
                      <option value="Fiji">Fiji</option>
                      <option value="Finland">Finland</option>
                      <option value="France">France</option>
                      <option value="France Metropolitan">France, Metropolitan</option>
                      <option value="French Guiana">French Guiana</option>
                      <option value="French Polynesia">French Polynesia</option>
                      <option value="French Southern Territories">French Southern Territories</option>
                      <option value="Gabon">Gabon</option>
                      <option value="Gambia">Gambia</option>
                      <option value="Georgia">Georgia</option>
                      <option value="Germany">Germany</option>
                      <option value="Ghana">Ghana</option>
                      <option value="Gibraltar">Gibraltar</option>
                      <option value="Greece">Greece</option>
                      <option value="Greenland">Greenland</option>
                      <option value="Grenada">Grenada</option>
                      <option value="Guadeloupe">Guadeloupe</option>
                      <option value="Guam">Guam</option>
                      <option value="Guatemala">Guatemala</option>
                      <option value="Guinea">Guinea</option>
                      <option value="Guinea-Bissau">Guinea-Bissau</option>
                      <option value="Guyana">Guyana</option>
                      <option value="Haiti">Haiti</option>
                      <option value="Heard and McDonald Islands">Heard and Mc Donald Islands</option>
                      <option value="Holy See">Holy See (Vatican City State)</option>
                      <option value="Honduras">Honduras</option>
                      <option value="Hong Kong">Hong Kong</option>
                      <option value="Hungary">Hungary</option>
                      <option value="Iceland">Iceland</option>
                      <option value="India">India</option>
                      <option value="Indonesia">Indonesia</option>
                      <option value="Iran">Iran (Islamic Republic of)</option>
                      <option value="Iraq">Iraq</option>
                      <option value="Ireland">Ireland</option>
                      <option value="Israel">Israel</option>
                      <option value="Italy">Italy</option>
                      <option value="Jamaica">Jamaica</option>
                      <option value="Japan">Japan</option>
                      <option value="Jordan">Jordan</option>
                      <option value="Kazakhstan">Kazakhstan</option>
                      <option value="Kenya">Kenya</option>
                      <option value="Kiribati">Kiribati</option>
                      <option value="Democratic People's Republic of Korea"> Democratic People's Republic of Korea
                      </option>
                      <option value="Korea">Korea</option>
                      <option value="Kuwait">Kuwait</option>
                      <option value="Kyrgyzstan">Kyrgyzstan</option>
                      <option value="Lao">Lao People's Democratic Republic</option>
                      <option value="Latvia">Latvia</option>
                      <option value="Lebanon">Lebanon</option>
                      <option value="Lesotho">Lesotho</option>
                      <option value="Liberia">Liberia</option>
                      <option value="Libyan Arab Jamahiriya">Libyan Arab Jamahiriya</option>
                      <option value="Liechtenstein">Liechtenstein</option>
                      <option value="Lithuania">Lithuania</option>
                      <option value="Luxembourg">Luxembourg</option>
                      <option value="Macau">Macau</option>
                      <option value="Macedonia">Macedonia, The Former Yugoslav Republic of</option>
                      <option value="Madagascar">Madagascar</option>
                      <option value="Malawi">Malawi</option>
                      <option value="Malaysia">Malaysia</option>
                      <option value="Maldives">Maldives</option>
                      <option value="Mali">Mali</option>
                      <option value="Malta">Malta</option>
                      <option value="Marshall Islands">Marshall Islands</option>
                      <option value="Martinique">Martinique</option>
                      <option value="Mauritania">Mauritania</option>
                      <option value="Mauritius">Mauritius</option>
                      <option value="Mayotte">Mayotte</option>
                      <option value="Mexico">Mexico</option>
                      <option value="Micronesia">Micronesia, Federated States of</option>
                      <option value="Moldova">Moldova, Republic of</option>
                      <option value="Monaco">Monaco</option>
                      <option value="Mongolia">Mongolia</option>
                      <option value="Montserrat">Montserrat</option>
                      <option value="Morocco">Morocco</option>
                      <option value="Mozambique">Mozambique</option>
                      <option value="Myanmar">Myanmar</option>
                      <option value="Namibia">Namibia</option>
                      <option value="Nauru">Nauru</option>
                      <option value="Nepal">Nepal</option>
                      <option value="Netherlands">Netherlands</option>
                      <option value="Netherlands Antilles">Netherlands Antilles</option>
                      <option value="New Caledonia">New Caledonia</option>
                      <option value="New Zealand">New Zealand</option>
                      <option value="Nicaragua">Nicaragua</option>
                      <option value="Niger">Niger</option>
                      <option value="Nigeria">Nigeria</option>
                      <option value="Niue">Niue</option>
                      <option value="Norfolk Island">Norfolk Island</option>
                      <option value="Northern Mariana Islands">Northern Mariana Islands</option>
                      <option value="Norway">Norway</option>
                      <option value="Oman">Oman</option>
                      <option value="Pakistan">Pakistan</option>
                      <option value="Palau">Palau</option>
                      <option value="Panama">Panama</option>
                      <option value="Papua New Guinea">Papua New Guinea</option>
                      <option value="Paraguay">Paraguay</option>
                      <option value="Peru">Peru</option>
                      <option value="Philippines">Philippines</option>
                      <option value="Pitcairn">Pitcairn</option>
                      <option value="Poland">Poland</option>
                      <option value="Portugal">Portugal</option>
                      <option value="Puerto Rico">Puerto Rico</option>
                      <option value="Qatar">Qatar</option>
                      <option value="Reunion">Reunion</option>
                      <option value="Romania">Romania</option>
                      <option value="Russia">Russian Federation</option>
                      <option value="Rwanda">Rwanda</option>
                      <option value="Saint Kitts and Nevis">Saint Kitts and Nevis</option>
                      <option value="Saint LUCIA">Saint LUCIA</option>
                      <option value="Saint Vincent">Saint Vincent and the Grenadines</option>
                      <option value="Samoa">Samoa</option>
                      <option value="San Marino">San Marino</option>
                      <option value="Sao Tome and Principe">Sao Tome and Principe</option>
                      <option value="Saudi Arabia">Saudi Arabia</option>
                      <option value="Senegal">Senegal</option>
                      <option value="Seychelles">Seychelles</option>
                      <option value="Sierra">Sierra Leone</option>
                      <option value="Singapore">Singapore</option>
                      <option value="Slovakia">Slovakia (Slovak Republic)</option>
                      <option value="Slovenia">Slovenia</option>
                      <option value="Solomon Islands">Solomon Islands</option>
                      <option value="Somalia">Somalia</option>
                      <option value="South Africa">South Africa</option>
                      <option value="South Georgia">South Georgia and the South Sandwich Islands</option>
                      <option value="Span">Spain</option>
                      <option value="SriLanka">Sri Lanka</option>
                      <option value="St. Helena">St. Helena</option>
                      <option value="St. Pierre and Miguelon">St. Pierre and Miquelon</option>
                      <option value="Sudan">Sudan</option>
                      <option value="Suriname">Suriname</option>
                      <option value="Svalbard">Svalbard and Jan Mayen Islands</option>
                      <option value="Swaziland">Swaziland</option>
                      <option value="Sweden">Sweden</option>
                      <option value="Switzerland">Switzerland</option>
                      <option value="Syria">Syrian Arab Republic</option>
                      <option value="Taiwan">Taiwan, Province of China</option>
                      <option value="Tajikistan">Tajikistan</option>
                      <option value="Tanzania">Tanzania, United Republic of</option>
                      <option value="Thailand">Thailand</option>
                      <option value="Togo">Togo</option>
                      <option value="Tokelau">Tokelau</option>
                      <option value="Tonga">Tonga</option>
                      <option value="Trinidad and Tobago">Trinidad and Tobago</option>
                      <option value="Tunisia">Tunisia</option>
                      <option value="Turkey">Turkey</option>
                      <option value="Turkmenistan">Turkmenistan</option>
                      <option value="Turks and Caicos">Turks and Caicos Islands</option>
                      <option value="Tuvalu">Tuvalu</option>
                      <option value="Uganda">Uganda</option>
                      <option value="Ukraine">Ukraine</option>
                      <option value="United Arab Emirates">United Arab Emirates</option>
                      <option value="United Kingdom">United Kingdom</option>
                      <option value="United States">United States</option>
                      <option value="United States Minor Outlying Islands">United States Minor Outlying Islands</option>
                      <option value="Uruguay">Uruguay</option>
                      <option value="Uzbekistan">Uzbekistan</option>
                      <option value="Vanuatu">Vanuatu</option>
                      <option value="Venezuela">Venezuela</option>
                      <option value="Vietnam">Viet Nam</option>
                      <option value="Virgin Islands (British)">Virgin Islands (British)</option>
                      <option value="Virgin Islands (U.S)">Virgin Islands (U.S.)</option>
                      <option value="Wallis and Futana Islands">Wallis and Futuna Islands</option>
                      <option value="Western Sahara">Western Sahara</option>
                      <option value="Yemen">Yemen</option>
                      <option value="Yugoslavia">Yugoslavia</option>
                      <option value="Zambia">Zambia</option>
                      <option value="Zimbabwe">Zimbabwe</option>
                    </select>
                  </div>
                  <div v-show="done2===8">
                    <button type="submit"  class="outline"  @click.stop.prevent="createUser();redirectToLogin();">let's go</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </transition>


      <!--RECOVERY -->

      <!--<form class="form form&#45;&#45;recovery framed">-->
        <!--<input type="email" placeholder="Email" class="input input&#45;&#45;top" />-->
        <!--<input type="submit" value="Reset" class="input input&#45;&#45;submit" />-->
    <!--</form>-->

 </form>
    <!--<label for="toggle&#45;&#45;login" class="text text&#45;&#45;small text&#45;&#45;centered"><b>Log in</b></label>-->


    <!--<label for="toggle&#45;&#45;login" class="text text&#45;&#45;small text&#45;&#45;centered"><b>Log in</b></label>-->
    <!--<label for="toggle&#45;&#45;signup" class="text text&#45;&#45;small text&#45;&#45;centered"><b>Sign up</b></label>-->
    <!--</form>-->


    <!--<div class="container">-->
    <!--<div class="chevron"></div>-->
    <!--<div class="chevron"></div>-->
    <!--<div class="chevron"></div>-->
    <!--</div>-->
    <div class="fullscreen-bg"></div>
  </div>
</template>

<!--<div v-if="showResponse"><h6>User created with Id: {{ response }}</h6></div>-->

<!--<button v-if="showResponse" @click="retrieveUser()">Retrieve user {{user.id}} data from database</button>-->

<!--<h4 v-if="showRetrievedUser">Retrieved User {{retrievedUser.email}} {{retrievedUser.login}} {{retrievedUser.password}}</h4>-->


<script>
  // import axios from 'axios'
  import {AXIOS} from './http-common'

  export default {

    name: 'user',

    data() {
      return {

        sliders: [
          {
            image: './../assets/584.jpg',
            active: false,
            activeClass: true
          },],
        rememberMe:false,
        response: [],
        errors: [],
        user: {
          email:'',
          password:'',
          year: null,
          month: null,
          day: null,
          country: null,
          languages: []
        },
        signError:null,
        logError:null,
        info: [
          {
            name: 'username',
            value: '',
            placeholder: 'Username',
            type: 'text',
            class: 'input input--top',
            pattern: /^[a-z0-9_-]{3,16}$/
          },
          {
            name: 'email',
            value: '',
            placeholder: 'Email',
            type: 'text',
            class: 'input',
            pattern: /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
          },
          {
            name: 'password',
            value: '',
            placeholder: 'Password',
            type: 'password',
            class: 'input',
            pattern: /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/
          },
          {
            name: 'password2',
            value: '',
            placeholder: 'Repeat password',
            type: 'password',
            class: 'input',
            pattern: /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/
          },
        ],

        controls: [],
        showResponse: false,
        retrievedUser: {},
        showRetrievedUser: false,
        show: false,


      }
    },
    updated(){
      this.signError = false;
      this.logError=false;
    },
mounted(){
  this.signError = false;
  this.logError=false;
},
    beforeMount() {
      this.signError = false;
      this.logError=false;
      for (let i = 0; i < this.info.length; i++) {
        this.controls.push({
          error: true,
          activated: false
        });
      }
    },

    methods: {

      // Fetches posts when the component is created.
      createUser() {
          //
          // params.append('username', this.info[0].value),
          // params.append('email', this.info[1] .value),
          // params.append('password', this.info[2].value),
          // params.append('country', this.user.country),
          // params.append('day', this.user.day),
          // params.append('month', this.user.month),
          // params.append('year', this.user.year),
          // params.append('languages', this.user.languages)

        AXIOS.post(`/public/signup`,{data:{'username': this.info[0].value,
                                            'email': this.info[1] .value ,
            'password': this.info[2].value,
            'country': this.user.country,
            'day': this.user.day,
            'month': this.user.month,
            'year': this.user.year,
            'languages': this.user.languages
        }})
          .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data;
            console.log(params);
            // this.user.id = response.data;
            console.log(response.data);
            this.showResponse = true
          })
          //   .then(router => {console.log(params);
          //   this.$router.push('Chat')

          // })
          .catch(e => {

            console.log(this.$store.getters.token);
            this.signError=true;
            console.log(this.signError);
          });
      },
      loginUser() {
        var params = new URLSearchParams();
        params.append('email', this.user.email),
          console.log(this.user.email);
          params.append('password', this.user.password),
            console.log( this.user.password);
          params.append('rememberMe', this.rememberMe.toString()),
            console.log(this.rememberMe.toString())

        AXIOS.post(`/public/login`,params)
          .then(response =>{
            this.$store.commit('LOGIN_TOKEN',response.data);
            console.log(this.$store.getters.token);

          }).catch(error =>{
            console.log("Error login")
          console.log(error.message)
            })






      },

      onInput(index, value) {
        let data = this.info[index];
        let control = this.controls[index];

        // params.append('password', this.user.password),
        // params.append('password2', this.user.password2)

        data.value = value;

        if (Object.is(data.name, 'password2')) {
          let password = this.info[index - 1];
          control.error = !Object.is(password.value, this.info[index].value)

        } else if(Object.is(data.name, 'password')){
          let password2=this.info[index +1];
          let controls2=this.controls[index+1];
          control.error = !data.pattern.test(value);
          controls2.error=!Object.is(data.value, password2.value);

        }else{
          control.error = !data.pattern.test(value);
        }
        control.activated = true
      },

      checkboxdone(str) {
        if (Object.is(this.user.languages.length, 3)) {
          if (Object.is(this.user.languages[0], str) || Object.is(this.user.languages[1], str) || Object.is(this.user.languages[2], str)) {
            return false;
          } else {
            return true;
          }
        }else {
          return false;
        }
      },
      redirectToMain(){
        console.log("redirect to main (logError= "+this.logError+" )" );
        if (!this.logError) {
           this.$router.push('main');
        }
      },
      redirectToLogin(){
        console.log("redirect to login (signError= "+ this.signError +" )" );

        if (!this.signError){
          this.$router.push('registration');
        }
      },
      moveSlider: function (index) {
        for (let i = 0; i < this.sliders.length; i++) {
          this.sliders[i].active = false;
          this.sliders[i].activeClass = false;
        }
        this.sliders[index].active = true;
        this.sliders[index].activeClass = true;
      }
      // retrieveUser () {
      //   AXIOS.post(`/registration/` + this.user.id)
      //     .then(response => {
      //       // JSON responses are automatically parsed.
      //       this.retrievedUser = response.data;
      //       console.log(response.data);
      //       this.showRetrievedUser = true
      //     })
      //     .catch(e => {
      //       this.errors.push(e)
      //     })
    },
    // updated(){
    //   this.signError=false;
    // },

    computed: {


  done() {
        let done = 0;
        for (let i = 0; i < this.controls.length; i++) {
          if (!this.controls[i].error) {
            done++;
          }
        }
        return done;
      },
      done2() {
        let done = 0;
        if (Object.is(this.user.languages.length,3)){
          done+=1;
        }
        for (let item in this.user) {
          if (!Object.is(this.user[item], null)) {
            done++;
          }
        }
        console.log(done);
        return done;
      },

    }
  }


</script>

<style lang="sass">


  .wrp
    width: 850px
    height: auto
    margin: 0 auto

    .slider
      width: 850px
      height: 200px

      &__item

        /*background: url('./../assets/584.jpg')*/
        height: 100%
        background-size: cover
        background-position: center
        border-radius: 4px
        position: center
        margin-left: -10.5rem

      &__nuv

        margin-top: 15px
        display: flex
        justify-content: center


</style>

<style lang="scss">

  .grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(550px, 1fr));
    grid-gap: 4px;

  }

  /*.grid div.grid {*/
  /*display: grid;*/
  /*grid-template-columns: repeat(auto-fit, minmax(550px, 1fr));*/
  /*grid-gap: 4px;*/

  /*}*/

  .grid div {
    /*background-color: #0b97c4;*/
    /*border: 1px solid #00a8e6;*/
    border-radius: 5px;
    padding: 8px 15px;
    color: rgba(182, 88, 125, 0.99);
    font-size: 18px;
    font-family: Roboto;

  }

  .grid div.subitems {
    display: grid;
    /*background-color: darkslateblue;*/
    grid-template-columns: repeat(auto-fit, minmax(160px, 1fr));
    grid-gap: 4px;

  }

  .grid div.subitems div:nth-child(21) {
    display: grid;
    /*background-color: lightcyan;*/
    grid-column: 5 / -1;
    grid-row: 6 / -1;
    grid-gap: 10px;

  }

  /*.grid div.subsubitems div {*/
  /*display: grid;*/
  /*background-color: midnightblue;*/
  /*grid-template-columns:1fr 1fr 1fr 1fr 1fr;*/

  /*}*/

  html, body {
    width: 100%;
    height: 100%;
    margin: 0;
    font-family: Helvetica, Arial, sans-serif;
    overflow: hidden;
  }

  .icon-danger {
    background: url("./../assets/spell.png") 95% no-repeat;
    background-size: 20px;
    padding: 5px 5px 5px 40px;
    width: 10px;
    height: 10px
  }

  .icon-success {
    background: url("./../assets/ok.png") 95% no-repeat;
    background-size: 20px;
  }

  .ghost {
    position: absolute;
    left: -100%;
  }

  .framed {
    position: absolute;
    top: 50%;
    left: 50%;
    width: 15rem;
    margin-left: -7.5rem;
  }

  .logo {
    margin-top: -22em;
    cursor: default;
  }

  .form {
    margin-top: -4.5em;
    transition: 1s ease-in-out;
  }

  .input {
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    font-size: 1.125rem;
    line-height: 3rem;
    width: 100%;
    height: 3rem;
    color: #444;
    background-color: rgba(255, 255, 255, .9);
    border: 111px;
    border-top: 1px solid rgba(255, 255, 255, 0.7);
    padding: 0 1rem;
    font-family: 'Open Sans', sans-serif;
  }

  .input:focus {
    outline: none;
  }

  .input--top {
    border-radius: 0.5rem 0.5rem 0 0;
    border-top: 0;
  }

  .input--submit {
    background-color: rgba(92, 168, 214, 0.9);
    color: #fff;
    font-weight: bold;
    cursor: pointer;
    border-top: 0;
    border-radius: 0 0 0.5rem 0.5rem;
    margin-bottom: 1rem;
  }

  .text {
    color: #FF787A;
    text-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
    text-decoration: none;
  }

  .text--small {
    opacity: 0.85;
    font-size: 0.75rem;
    cursor: pointer;
  }

  .text--small:hover {
    opacity: 1;
  }

  .text--omega {
    width: 200%;
    margin: 0 0 1rem -50%;
    font-size: 1.5rem;
    line-height: 1.125;
    font-weight: normal;
  }

  .text--centered {
    /*display: block;*/
    text-align: center;
  }

  .text--border-right {
    border-right: 1px solid rgba(255, 255, 255, 0.5);
    margin-right: 0.75rem;
    padding-right: 0.75rem;
  }

  .legal {
    position: absolute;
    bottom: 1.125rem;
    left: 1.125rem;
  }

  @keyframes move-left {
    0%{
      transform: translate3d(50px,40px,0px);
      animation-timing-function: ease-in;
    }
    50% { transform: translate3d(50px, 50px, 0px);
      animation-timing-function: ease-out;
    }
    100% {
      transform: translate3d(50px, 40px, 0px);
    }
  }
  .photo-cred {
    position: absolute;
    right: 1.125rem;
    bottom: 1.125rem;
  }

  .fullscreen-bg {

    position: fixed;
    z-index: -1;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background: url("./../assets/485654-PH172E-105.jpg") center;
    background-size: cover;
  }

  @mixin check-box($size: 17px, $font-size: 16px, $box-stroke: 1px, $check-stroke: 2px, $border-radius: 2px, $check-contain: true, $focus-glow: #2196F3) {
    // hide native styling
    position: absolute;
    left: -9999px;

    + label {
      position: relative;
      font-size: $font-size;
      padding-left: $size + $check-stroke + $box-stroke + 10px;
      line-height: $size + $check-stroke + $box-stroke;
      padding-top: round($size / 2 - $font-size / 2 + $check-stroke);

      // Use the label's before to make the box:
      &:before {
        content: '';
        position: absolute;
        left: 0;
        top: 0;
        width: $size + $check-stroke + $box-stroke;
        height: $size + $check-stroke + $box-stroke;
        border: $box-stroke solid #aaa;
        background: #f8f8f8;
        border-radius: $border-radius;
      }

      // Use the label's after to make the checkmark:
      &:after {
        border-left: $check-stroke solid #666;
        border-bottom: $check-stroke solid #666;
        color: #09ad7e;
        content: '';
        position: absolute;
        transition: all .2s;
        transform: scale(1) rotate(-45deg);

        @if $check-contain {
          left: round(($size + $check-stroke) * .23 + ($box-stroke * 1.2));
          height: round($size * .18);
          top: round(($size + $check-stroke) / 3.4 + ($box-stroke * 1.2));
          width: round($size * .5);
        } @else {
          left: round(($size + $check-stroke) * .27 + ($box-stroke * 1.2));
          height: round(($size + $check-stroke) * .27);
          top: round($box-stroke * 1.2);
          width: round($size + $check-stroke);
        }
      }
    }

    // inactive checkmark
    &:not(:checked) + label:after {
      opacity: 0;
      transform: scale(0) rotate(-45deg);
    }
    // active checkmark
    &:checked + label:after {
      opacity: 1;
    }

    // disabled checkbox
    &:disabled + label {
      color: #bbb;
      cursor: not-allowed;

      &:before {
        background-color: rgba(#000, .06);
        border-color: rgba(#000, .1);
      }

      &:after {
        border-color: rgba(#000, .2);
      }
    }

    // focus
    &:focus + label:before {
      @if ($focus-glow) {
        border: $box-stroke solid $focus-glow;
        box-shadow: 0 0 3px 3px rgba($focus-glow, .1);
      } @else {
        border: $box-stroke solid rgba(#000, .5);
      }
    }

    // Entire label + checkbox should have pointer cursor if not disabled
    &:not(:disabled) + label {
      &:hover {
        cursor: pointer;

        &:before {
          border: $box-stroke solid #2196F3;
        }
      }
    }
  }

  // call it
  input[type="checkbox"] {
    //@include check-box();
  }

  @import url(https://fonts.googleapis.com/css?family=Roboto:400,300);

  @keyframes click-wave {
    0% {
      height: 40px;
      width: 40px;
      opacity: 0.35;
      position: relative;
    }
    100% {
      height: 200px;
      width: 200px;
      margin-left: -80px;
      margin-top: -80px;
      opacity: 0;
    }
  }

  .option-input {
    -webkit-appearance: none;
    -moz-appearance: none;
    top: 13.33333px;
    left: 5px;
    height: 40px;
    width: 40px;
    transition: all 0.15s ease-out 0s;
    background: #35353D;
    border: none;
    color: #fff;
    cursor: pointer;
    display: inline-block;
    margin-right: 0.5rem;
    margin-bottom: -0.8rem;
    outline: none;
    /*position: relative;*/
    z-index: 1000;
    opacity: 0.7;
  }

  .option-input:hover {
    background: #1FD6CA;
  }

  .option-input:checked {
    background: #FF7D65;
  }

  .option-input:disabled {
    background: #bcbebf;
  }

  .option-input:checked::before {
    height: 40px;
    width: 40px;
    position: absolute;
    content: '✔';
    display: inline-block;
    font-size: 26.66667px;
    text-align: center;
    line-height: 40px;
  }

  .option-input:checked::after {
    -webkit-animation: click-wave 0.65s;
    -moz-animation: click-wave 0.65s;
    animation: click-wave 0.65s;
    background: #FF7D65;
    content: '';
    display: block;
    position: relative;
    z-index: 100;
  }

  .option-input.radio {
    border-radius: 50%;
  }

  .option-input.radio::after {
    border-radius: 50%;
  }

  /* selects */

  .styled-select1 {
    background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;

    height: 29px;
    width: 100px;
    overflow: hidden;
    opacity: 0.8;

  }

  .styled-select2 {
    background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;
    height: 29px;
    width: 100px;
    overflow: hidden;
    opacity: 0.8;

  }

  .styled-select3 {
    background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;
    height: 29px;
    width: 100px;
    opacity: 0.8;

  }

  .styled-select4 {
    background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;
    height: 29px;
    width: 100px;
    overflow: hidden;
    opacity: 0.8;
  }

  .styled-select1 select {
    background: transparent;
    border: none;
    font-size: 14px;
    height: 29px;
    padding: 5px; /* If you add too much padding here, the options won't show in IE */
    width: 130px;
    overflow: hidden;
  }

  .styled-select2 select {
    background: transparent;
    border: none;
    font-size: 14px;
    height: 29px;
    padding: 5px; /* If you add too much padding here, the options won't show in IE */
    width: 130px;
    overflow: hidden;
  }

  .styled-select3 select {
    background: transparent;
    border: none;
    font-size: 14px;
    height: 29px;
    padding: 5px; /* If you add too much padding here, the options won't show in IE */
    width: 147px;
  }

  .styled-select4 select {
    background: transparent;
    border: none;
    font-size: 14px;
    height: 29px;
    padding: 5px; /* If you add too much padding here, the options won't show in IE */
    width: 130px;
  }

  .container {
    margin: 20px auto;
    width: 500px;
    text-align: center;
  }

  /* -------------------- Rounded Corners */
  .rounded {
    -webkit-border-radius: 20px;
    -moz-border-radius: 20px;
    border-radius: 20px;
  }

  .semi-square {
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
  }

  /* -------------------- Colors: Background */

  .yellow {
    background-color: #FF7D65;
  }

  .green {
    background-color: #1FD6CA;
  }

  button {
    cursor: pointer;
    outline: none;
    &.outline {
      z-index: 3;
      background: transparent;
      color: #4E5277;
      font-size: 14px;
      right: 10px;
      border-color: #4E5277;
      border-style: solid;
      border-radius: 22px;
      padding: 10px 35px;
      text-transform: uppercase;
      transition: all 0.2s linear;
      a {
        text-decoration: none;
      }
    }
    &.outline:hover {
      color: white;
      background: #4E5277;
      opacity: 0.8;

      transition: all 0.2s linear;
    }
    &.outline:active {
      border-radius: 22px;
    }
  }

  #toggle--login:checked ~ .form--signup {
    left: 200%;
    visibility: hidden;
  }

  #toggle--signup:checked ~ .form--login {
    left: -100%;
    visibility: hidden;
  }

  /*#toggle--recovery:checked ~ .form--recovery {*/
    /*top: 500%;*/
    /*visibility:hidden;*/
  /*}*/

  @media (height: 300px) {
    .legal, .photo-cred {
      display: none
    }
  }


</style>

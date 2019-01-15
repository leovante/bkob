<template>
  <div>

    <div class="section-title">
      <div class="clickme">
      <p>Please indicate your favorite programming languages ​​and some personal info.</p>

    </div>
  </div>
    <img class="logo framed" src="./../assets/micro-micro.png" alt="Bkob logo" />
    <div class="card">
      <div class="header">
        <div class="styled-select1 yellow rounded">
          <select v-model="user.day">
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
          <select v-model="user.month">
            <option disabled selected>MONTH</option>
            <option value="01">January</option>
            <option value="02">February</option>
            <option value="03">March</option>
            <option value="04">April</option>
            <option value="05">May</option>
            <option value="06">June</option>
            <option value="07">July</option>
            <option value="08">August</option>
            <option value="09">September</option>
            <option value="10">October</option>
            <option value="11">November</option>
            <option value="12">December</option>

          </select>
        </div>
        <div class="styled-select3 yellow rounded">
          <select v-model="user.year" >
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
          <select v-model="user.country">
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
            <option value="Democratic People's Republic of Korea">Korea, Democratic People's Republic of</option>
            <option value="Korea">Korea, Republic of</option>
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

        <button type="submit" class="outline" @click="userSet(); redirect() ">let's go</button>

        <div class="container">
          <div class="chevron"></div>
          <div class="chevron"></div>
          <div class="chevron"></div>
        </div>



        <table>
        <tr>
        <td v-for="(item, index) in info"><div class="content" >  <label >
        <input type="checkbox" class="option-input checkbox" />
        {{item.name}}
        </label>
        </div>
        </td>
        </tr>
          <tr class="" >
            <td v-for="(item, index) in info2" ><div class="content" >  <label >
              <input type="checkbox" class="option-input checkbox" />
              {{item.name}}
            </label>
            </div>
            </td>
          </tr>
          <tr  >
            <td v-for="(item, index) in info3" ><div class="content" >  <label >
              <input type="checkbox" class="option-input checkbox" />
              {{item.name}}
            </label>
            </div>
            </td>
          </tr>
          <tr  >
            <td v-for="(item, index) in info4" ><div class="content" >  <label >
              <input type="checkbox" class="option-input checkbox"/>
              {{item.name}}
            </label>
            </div>
            </td>
          </tr>
          <tr  >
            <td v-for="(item, index) in info5" ><div class="content" >  <label >
              <input type="checkbox" class="option-input checkbox"  />
              {{item.name}}
            </label>
            </div>
            </td>
          </tr>
        </table>

        </div>
      </div>


  <div class="fullscreen-bg"></div>
  </div>

    <!--<td><div class="content">-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--Clojure-->
             <!--</div></td>-->


              <!--<td><div class="content"> <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--C#-->
              <!--</label></div></td>-->
            <!--</tr>-->
            <!--<tr>-->
              <!--<td><div class="content">  <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--Go-->
              <!--</label></div></td>-->
              <!--<td><div class="content"> <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--JavaScript-->
              <!--</label></div></td>-->
              <!--<td><div class="content">  <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--PHP-->
              <!--</label></div></td>-->
              <!--<td><div class="content">  <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--Ruby-->
              <!--</label></div></td>-->

            <!--</tr>-->
            <!--<tr>-->
              <!--<td><div class="content">  <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--Python-->
              <!--</label></div></td>-->
              <!--<td><div class="content"> <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--Shell-->
              <!--</label></div></td>-->
              <!--<td><div class="content">  <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--Sql-->
              <!--</label></div></td>-->
              <!--<td><div class="content"> <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--Swift-->
              <!--</label></div></td>-->

            <!--</tr>-->
            <!--<tr>-->
              <!--<td><div class="content"> <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--Crystal-->
              <!--</label></div></td>-->
              <!--<td><div class="content">  <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--Elixir-->
              <!--</label></div></td>-->
              <!--<td><div class="content"> <label>-->
                <!--<input type="checkbox" class="option-input checkbox" />-->
                <!--Dart-->
              <!--</label></div></td>-->
             <!--<td><div class="content"><label>-->
               <!--<input type="checkbox" class="option-input checkbox" />-->
               <!--Haskell-->
             <!--</label></div></td>-->


</template>

<script>
  import {AXIOS} from './http-common'

    export default {
      name: "UserSettings",

      data() {
        return {

          response: [],
          errors: [],
          user: {
            year: '',
            month: '',
            day: '',
            country:'',
            languages: [],

          },
          showResponse: false,
          retrievedUser: {},
          showRetrievedUser: false
        }
      },
      methods: {
        redirect() {
          this.$router.push('Main')
        },

        userSet() {
          var params = new URLSearchParams();
            params.append('languages', this.user.languages[''] ),
            params.append('year', this.user.year),
            params.append('month', this.user.month),
            params.append('day', this.user.day),
            params.append('country', this.user.country),

            AXIOS.post(`/public/userset`, params)
              .then(response => {
                // JSON responses are automatically parsed.
                this.response = response.data;

                this.user.id = response.data;
                console.log(response.data);
                this.showResponse = true
              })
              //   .then(router => {
              //   this.$router.push('Chat')
              // })
              .catch(e => {
                this.errors.push(e)
              });


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
      height: 500px
      overflow: hidden
      &__item
        height: 100%
        background-size: cover
        background-position: center
        border-radius: 4px
      &__nuv
        margin-top: 15px
        display: flex
        justify-content: center
        li.active_nuv
          background-color: #35475F
        li
          &:not(:last-of-type)
            margin-right: 7px
          cursor: pointer
          width: 10px
          height: 10px
          border-radius: 50%
          border: 1px solid #35475F
          transition: all .25s ease
          &:hover
            background-color: #35475F


</style>

<style lang="scss">
  @import url(https://fonts.googleapis.com/css?family=Roboto:400,300);

  *{font-family: 'Roboto', sans-serif;}

  table {
    width: 80%;

  }


  td {
    width: 23.33%;
    position: relative;
  }

  td:after {
    content: '';
    display: block;
    margin-top: 50%;
  }
  td .content {
    position: absolute;
    top: 30px;
    bottom: 0;
    left: 30px;
    right: 0;
    /*background: gold;*/
  }

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
    -ms-appearance: none;
    -o-appearance: none;
    appearance: none;
    position: relative;
    top: 13.33333px;
    right: 0;
    bottom: 0;
    left: 5px;
    height: 40px;
    width: 40px;
    transition: all 0.15s ease-out 0s;
    background: #cbd1d8;
    border: none;
    color: #fff;
    cursor: pointer;
    display: inline-block;
    margin-right: 0.5rem;
    outline: none;
    /*position: relative;*/
    z-index: 1000;
  }
  .option-input:hover {
    background: #9faab7;
  }
  .option-input:checked {
    background: #FF7D65;
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


  .container {
    margin: 20px auto;
    width: 500px;
    text-align: center;
  }


  .fullscreen-bg {
    position: fixed;
    z-index: -1;
    top:0; right:0; bottom:0; left:0;
    background: url(https://www.shutterstock.com/blog/wp-content/uploads/sites/5/2017/04/featured-tools.png) center;
    background-size: cover;
  }


  .card {
    max-width: 850px;
    max-height: 800px;
    border-radius: 8px;
    margin: 60px auto 40px auto;
    /*display: block;*/
    /*overflow: hidden;*/
    box-shadow: 0 1px 4px 0 rgba(0,0,0,.45);
    font-family: 'Roboto';
    color: #444;
    font-size: 14px;
    background-color: #000000;
    opacity: .6;
    /*text-decoration: none;*/

    /*transition: all .15s ease;*/
  }
  .active .header {
    animation: click .5s;
  }
  .header {
    height: 490px;
    background-size: cover;
    background-position: bottom center;
    color: white;
    position: relative;
  }
  .header h2 {
    bottom: 0;
    margin: 16px;
    position: absolute;
    font-weight: 400;
    font-size: 2em;
    opacity: .85;
    line-height: 1.2;
  }

  .content p {
    max-height: 0;
    margin: 0;
    overflow: hidden;
    transition: all .5s ease;
  }
  .active {
    transition-delay: .5s;
    transform: scale(1.15);
    max-height: 600px;
  }
  .active .content p {
    display: block;
    max-height: 600px;
    margin: 12px 0;
  }
  .content p:first-child {
    max-height: 600px;
    margin: 12px 0;
  }



  body {
    padding: 4.9vw;

    p {
      font-weight:bold;
      font-family: "Titillium Web", sans-serif;
      text-align: center;
      /*font-weight: 100;*/
      max-width: 350px;
      margin: 50px auto;
      color: #5882A0;
    }
  }

  .section-title {
    position: relative;
  }

  .framed {
    position: absolute;
    top: 50%; left: 50%;
    /*width: 15rem;*/
    margin-left: -2.2rem;
  }

  .clickme {
    margin: 1.5em auto;
    padding: 1em 2em;
    position: relative;
    font-size: 1em;
    max-width: 400px;
    background: #fff;
    border-radius: 100px;
    opacity: .8;

    &:after {
      content: '';
      margin-left: -10px;
      width: 0;
      height: 0;
      position: absolute;
      bottom: -20px;
      left: 50%;
      border-style: solid;
      border-width: 20px 10px 0 10px;
      border-color: #fff transparent transparent transparent;
    }
  }

  /* selects */

  .styled-select1 {
    background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;
    display: block;
    height: 29px;
    overflow: hidden;
    width: 100px;
    position: absolute;
    top: 55px;
    bottom: 0;
    left: 680px;
    right: 0;

  }

  .styled-select2 {
    background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;
    display: block;
    height: 29px;
    overflow: hidden;
    width: 100px;
    position: absolute;
    top: 105px;
    bottom: 0;
    left: 680px;
    right: 0;

  }

  .styled-select3 {
       background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;
       display: block;
       height: 29px;
       overflow: hidden;
       width: 100px;
       position: absolute;
       top: 155px;
       bottom: 0;
       left: 680px;
       right: 0;

     }

  .styled-select4 {
    background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;
    display: block;
    height: 29px;
    overflow: hidden;
    width: 100px;
    position: absolute;
    top: 205px;
    bottom: 0;
    left: 680px;
    right: 0;

  }

  .styled-select1 select {
    background: transparent;
    border: none;
    font-size: 14px;
    height: 29px;
    padding: 5px; /* If you add too much padding here, the options won't show in IE */
    width: 115px;
  }

  .styled-select2 select {
    background: transparent;
    border: none;
    font-size: 14px;
    height: 29px;
    padding: 5px; /* If you add too much padding here, the options won't show in IE */
    width: 115px;
  }

  .styled-select3 select {
    background: transparent;
    border: none;
    font-size: 14px;
    height: 29px;
    padding: 5px; /* If you add too much padding here, the options won't show in IE */
    width: 115px;
  }

  .styled-select4 select {
    background: transparent;
    border: none;
    font-size: 14px;
    height: 29px;
    padding: 5px; /* If you add too much padding here, the options won't show in IE */
    width: 115px;
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

  .yellow  { background-color: #FF7D65; }
  .green { background-color: #1FD6CA; }




  button {
    cursor: pointer;
    outline: none;
    &.outline {
      position: absolute;
      top: 380px;
      bottom: 60px;
      left: 660px;
      right: 0;
      z-index: 3;
      background: transparent;
      color: #1FACE4;
      font-size: 14px;
      border-color: #1FACE4;
      border-style: solid;
      border-radius: 22px;
      padding: 10px 40px;
      text-transform: uppercase;
      transition: all 0.2s linear;
      a {
        text-decoration: none;
      }
    }
    &.outline:hover {
      color: white;
      background: #1FACE4;

      transition: all 0.2s linear;
    }
    &.outline:active {
      border-radius: 22px;
    }

  }

  $base: 0.6rem;

  .chevron {
    position: absolute;
    top: 255px;
    bottom: 0;
    left: 710px;
    right: 0;

    width: $base * 3.5;
    height: $base * 0.8;
    opacity: 0;
    transform: scale(0.3);
    animation: move-chevron 3s ease-out infinite;
  }

  .chevron:first-child {
    animation: move-chevron 3s ease-out 1s infinite;
  }

  .chevron:nth-child(2) {
    animation: move-chevron 3s ease-out 2s infinite;
  }

  .chevron:before,
  .chevron:after {
    content: '';
    position: absolute;
    top: 0;
    height: 100%;
    width: 50%;
    background: #17A4DC;
  }

  .chevron:before {
    left: 0;
    transform: skewY(30deg);
  }

  .chevron:after {
    right: 0;
    width: 50%;
    transform: skewY(-30deg);
  }

  @keyframes move-chevron {
    25% {
      opacity: 1;
    }
    33.3% {
      opacity: 1;
      transform: translateY($base * 3.8);
    }
    66.6% {
      opacity: 1;
      transform: translateY($base * 5.2);
    }
    100% {
      opacity: 0;
      transform: translateY($base * 8) scale(0.5);
    }
  }






</style>

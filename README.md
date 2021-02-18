<h1 align="center"> Progetto Programmazione ad Oggetti </h1>

<h1 align="center"> TicketmasterCanada </h1>
 

La nostra applicazione permetta di studiare gli eventi che avranno luogo in Canada, utilizzando le API del sito [Ticketmaster](https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/#search-events-v2). Inoltre permettere all'utente finale di visualizzare delle statistiche per ogni stato. Infine, l'utente ha la possibilità di calcolare/filtrare le statistiche in base a dei filtri scelti dall'utente stesso.
</p>

## **Scaletta dei contenuti**

* [Introduzione](#intro)
* [Installazione](#install)
* [Diagrammi UML](#uml)
* [Rotte](#rotte)
* [Rotte Aggiuntive](#rotteaggiuntive)
* [Test](#test)
* [Documentazione](#doc)
* [Autori](#autor)

<a name="intro"></a>
## Introduzione

L'applicazione TicketmasterCanada si divide in diverse funzionalità.
Permette all'utente di visualizzare:
* Gli eventi dell'intero Canada
* Gli eventi di un singolo Stato canadese 
(Columbia Britannica, Alberta, Saskatchewan, Manitoba, Ontario, Quèbec, Nuovo Brunswick, Nuova Scozia, Isola del Principe Edoardo, Terranova e Labrador, Territorio Yukon, Territori del Nord-Ovest e Territorio Nunavut)
* Gli eventi di un singolo market (102, 103, 106, 107, 108, 110, 111, 112, 120)
* Gli eventi di un singolo source (universe, tmr, ticketmaster, frontgate)
* Gli eventi a partire da una parola chiave
* Gli eventi di una particolare tipologia
* Gli eventi di un particolare genere
* Gli eventi di un particolare sottogenere

Inoltre l'utente ha a disposizione diversi modi per filtrare gli eventi:
* Confrontare gli Stati canadesi filtrando per source, tipolgia dell'evento, genere dell'evento, sottogenere dell'evento oppure confrontando il totale degli eventi
* Confrontare i vari market 
* Confrontare per source filtrando per Stati
* Confrontare per tipologia degli eventi filtrando per Stati
* Confrontare per genere degli eventi filtrando per Stati
* Confrontare per sottogenere degli eventi filtrando per Stati

L'applicazione salva automaticamente al momento dell'avvio, una serie di eventi principali del Canada all'interno di un file e, infine, permette anche di salvare all'interno di un file gli eventi di uno Stato canadese indicato dall'user.

<a name="install"></a>
## Installazione
TicketmasterCanada è installabile dal Git Bash digitando:  
```
git clone https://github.com/FabioCarosi/ProgettoOOP.git
```
Oppure è possibile scaricare il progetto scaricandolo in formato Zip dalla pagina fi GitHub. 
<a name="config"></a>



<a name="uml"></a>
## Diagrammi UML

*Use Case Diagram*



***

*Class Diagram*


* it.univpm.TicketmasterCanada.controller

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Controller.jpg)

* it.univpm.TicketmasterCanada.exception

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Exceptions.jpg)


* it.univpm.TicketmasterCanada.files

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Files.jpg)

* it.univpm.TicketmasterCanada.filters

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Filters.jpg)

* it.univpm.TicketmasterCanada.model

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Model.jpg)

* it.univpm.TicketmasterCanada.service

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Service.jpg)

* it.univpm.TicketmasterCanada.stats

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Stats.jpg)

* Diagramma Finale

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Final.jpg)

***



![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/SequenceDiagrams/CountryStateMarket.png)
*Sequance Diagram (parte 1)*

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/SequenceDiagrams/Filters.png)
*Sequance Diagram (parte 2)*

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/SequenceDiagrams/SegmentGenreSubgenreSourceKeyword.png)
*Sequance Diagram (parte 3)*

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/SequenceDiagrams/saveEvents.png)
*Sequance Diagram (parte 4)*





***


<a name="rotte"></a>
## Rotte
Le richieste che l'utente può effettuare tramite Postman devono essere all'indirizzo
```
localhost:8080
```
Le rotte definite sono le seguenti:

N° | Tipo | Rotta | Descrizione
----- | ------------ | -------------------- | ----------------------
[1](#1) | ` GET ` | `/countryEvents` | *Restituisce un JSONObject con gli eventi, insieme alle relative informazioni, in programma nell'intero Canada.*
[2](#2) | ` GET ` | `/stateEvents?stateCode=<stateCode>` |*Restituisce un JSONObject con gli eventi, insieme alle relative informazioni, in programma nello Stato canadese passato come parametro.*
[3](#3) | ` POST ` | `/statsFilter` | *Consente di effettuare statistiche sulle previsioni azzeccate, con periodicità che varia da 1 a 5 giorni. Inoltre, in base alla richiesta dell'utente, l'applicazione filtrerà le città che rispettano le condizioni espresse circa la soglia di errore.*
[4](#4) | ` GET ` | `/saveEvents?stateCode=<stateCode>` | *Restituisce un file contente gli eventi dello State canadese passato come parametro. Se l'utente inserisce lo stateCode = CA si visualizzano gli eventi dell'intero Canada.*


<a name="1"></a>
## 1.   /countryEvents

Questa rotta restituisce gli eventi aventi luogo in Canada sotto forrma di un JSONObject.
In questa rotta non vanno aggiunti ulteriori parametri.

### Esempio

La rotta viene lanciata tramite il seguente indirizzo:
```
localhost:8080/countryEvents
```
Otteniamo come response un JSONObject del seguente tipo:
```
{
    "Evento": [
        {
            "address": "600 Block Hamilton St",
            "data": "2021-06-22",
            "orario": "20:00:00",
            "url": "http://www.ticketsnow.com/InventoryBrowse/TicketList.aspx?PID=2925225",
            "cityName": "Vancouver",
            "stateName": "British Columbia",
            "subgenre": "Musical",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Hamilton",
            "genre": "Theatre",
            "stateCode": "BC",
            "id": "Z7r9jZ1Ae0PFP",
            "countryName": "Canada"
        },
        {
            "address": "600 Block Hamilton St",
            "data": "2021-06-23",
            "orario": "20:00:00",
            "url": "http://www.ticketsnow.com/InventoryBrowse/TicketList.aspx?PID=2925226",
            "cityName": "Vancouver",
            "stateName": "British Columbia",
            "subgenre": "Musical",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Hamilton",
            "genre": "Theatre",
            "stateCode": "BC",
            "id": "Z7r9jZ1Ae0PFJ",
            "countryName": "Canada"
        },
        {
            "address": "600 Block Hamilton St",
            "data": "2021-06-24",
            "orario": "20:00:00",
            "url": "http://www.ticketsnow.com/InventoryBrowse/TicketList.aspx?PID=2921731",
            "cityName": "Vancouver",
            "stateName": "British Columbia",
            "subgenre": "Musical",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Hamilton",
            "genre": "Theatre",
            "stateCode": "BC",
            "id": "Z7r9jZ1Ae0-js",
            "countryName": "Canada"
        },
        //OMISSIS
        {
            "address": "132 Front St E",
            "data": "2021-02-19",
            "orario": "14:00:00",
            "url": "https://www.universe.com/events/museum-of-illusions-february-19th-2021-tickets-toronto-X4ZGNC?ref=ticketmaster",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Magic",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Museum of Illusions - February 19th, 2021",
            "genre": "Magic & Illusion",
            "stateCode": "ON",
            "id": "LvZ189gneLW606Yvvu7vF",
            "countryName": "Canada"
        },
        {
            "address": "132 Front St E",
            "data": "2021-02-19",
            "orario": "13:00:00",
            "url": "https://www.universe.com/events/museum-of-illusions-february-19th-2021-tickets-toronto-X4ZGNC?ref=ticketmaster",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Magic",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Museum of Illusions - February 19th, 2021",
            "genre": "Magic & Illusion",
            "stateCode": "ON",
            "id": "LvZ189gneLW606Yvvu7vZ",
            "countryName": "Canada"
        }
    ]
}       
        
```
La rotta non lancia alcuna eccezione, non essendo necessario l'inserimento di parametri.

<a name=2></a>
## 2.   /stateEvents?stateCode=<stateCode>

Questa rotta restituisce gli eventi aventi luogo nello Stato canadese che viene inserito come parametro dall'user. 
Gli Stati vanno inseriti sotto forma di una stringa di due caratteri MAIUSCOLI seguendo la seguente tabella:
N° | Provincia Canadese | stateCode 
----- | ------------ | -------------------- 
1| `Columbia Britannica` | `BC` 
2| `Alberta ` | `AB` 
3| `Saskatchewan ` | `SK` 
4| `Manitoba ` | `MB` 
5| `Ontario ` | `ON` 
6| `Quèbec ` | `QC` 
7| `Nuovo Brunswick ` | `NB` 
8| `Nuova Scozia ` | `NS` 
9| `Isola del Principe Edoardo ` | `PE` 
10| `Terranova e Labrador ` | `NL`
11| `Territorio Yukon ` | `YT` 
12| `Territori del Nord-Ovest ` | `NT` 
13| ` Territorio Nunavut ` | `NU` 
14| ` CANADA `| `CA`

Lo stateCode "CA" è stato implementato per effettuare una ricerca nell'intero territorio canadese. Questo codice è stato aggiunto per tutte le rotte che richiedono uno stateCode.
Qualunque altro stateCode al di fuori di quelli nella tabella non è supportato perchè al di fuori del territorio canadese, partirà dunque un'eccezione. 

### Esempio

La rotta viene lanciata tramite un indirizzo di questo tipo: 
```
localhost:8080/stateEvents/?stateCode=AB
```
Otteniamo come response un JSONObject del seguente tipo:
```
{
    "Evento": [
        {
            "address": "11455 87 Ave Nw",
            "data": "2021-07-27",
            "orario": "20:00:00",
            "url": "http://www.ticketsnow.com/InventoryBrowse/TicketList.aspx?PID=2925475",
            "cityName": "Edmonton",
            "stateName": "Alberta",
            "subgenre": "Musical",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Hamilton",
            "genre": "Theatre",
            "stateCode": "AB",
            "id": "Z7r9jZ1Ae0Pog",
            "countryName": "Canada"
        },
        {
            "address": "11455 87 Ave Nw",
            "data": "2021-07-28",
            "orario": "20:00:00",
            "url": "http://www.ticketsnow.com/InventoryBrowse/TicketList.aspx?PID=2925477",
            "cityName": "Edmonton",
            "stateName": "Alberta",
            "subgenre": "Musical",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Hamilton",
            "genre": "Theatre",
            "stateCode": "AB",
            "id": "Z7r9jZ1Ae0PoM",
            "countryName": "Canada"
        },
        //OMISSIS
         {
            "address": "1415 14 Ave. NW",
            "data": "2021-10-03",
            "orario": "16:00:00",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.ca/iliza-the-forever-tour-calgary-alberta-10-03-2021/event/1100583CCCFE54F5",
            "marketID": "108",
            "marketName": "Calgary and Southern Alberta",
            "cityName": "Calgary",
            "stateName": "Alberta",
            "subgenre": "Comedy",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "minPrice": 45.5,
            "name": "Iliza: The Forever Tour",
            "genre": "Comedy",
            "stateCode": "AB",
            "currency": "CAD",
            "id": "1Av7ZpdGkSGTPKg",
            "countryName": "Canada",
            "maxPrice": 202
        },
        {
            "address": "1415 14 Ave. NW",
            "data": "2021-10-05",
            "orario": "20:30:00",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.ca/wardruna-calgary-alberta-10-05-2021/event/110058F1BCC60D3E",
            "marketID": "108",
            "marketName": "Calgary and Southern Alberta",
            "cityName": "Calgary",
            "stateName": "Alberta",
            "subgenre": "World",
            "countryCode": "CA",
            "segment": "Music",
            "minPrice": 39.5,
            "name": "Wardruna",
            "genre": "World",
            "stateCode": "AB",
            "currency": "CAD",
            "id": "1778vbG62kHsOVX",
            "countryName": "Canada",
            "maxPrice": 64.5
        }
    ]
}
        
```
La rotta può generare la seguente eccezione: 
* WrongStateException: se si inserisce un stateCode diversi da quelli dell'elenco
```
US non è un valore ammesso
```

<a name=3></a>
## 3.    /statsFilter

La terza rotta è di tipo POST con il seguente indirizzo:
```
localhost:8080/statsFilter
```
Richiede un body del seguente tipo:
```
{ 
	 "comparator": "state", 
	 "elements": [
	 {
	  		 "name": "AB" 
	   	}, 
	   	{
	   		 "name": "BC" 
	   	},
	   	{
	   		 "name": "MB" 
	   	}

	   ],
	   "param": "genre",
	   "value": "Pop",
	   "period": 6
}
```

- **comparator**: rappresenta che tipo di elementi si vogliono confrontare tra loro.
I comparator ammessi sono: `country`  , `state`, `market`, `segment`, `genre`, `subgenre` o `source`.
- **elements**: sono gli elementi che si vogliono confrontare. Se il _comparator_ è _country_ non è necessario passare elementi nel body, in quanto l'applicazione analizzerà automaticamente tutti gli Stati con del Canada.
- **parameter**: rappresenta il parametro su cui si vuole effettuare il confronto. 
Nel caso in cui comparator sia `country` oppure _state i parameter ammessi sono: `total`, `source`, `segment`, `genre` e `subgenre`.
Nel caso in cui comparator sia `market` il parameter ammesso è: `total`.
Nel caso in cui comparator sia `source` , `segment` , `genre` oppure `subgenre` il parameter ammesso è: `state`.
- **value**: rappresenta il valore del parametro su cui si vuole effettuare il confronto.
- **period**: indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto (i valori ammesi sono: 1, 3, 6 oppure 12).

Otteniamo come response un JSONObject del seguente tipo:
  ```
[
    {
        "totalEvents": 8,
        "state": "AB"
    },
    {
        "totalEvents": 9,
        "state": "BC"
    },
    {
        "totalEvents": 4,
        "state": "MB"
    },
    {
        "Events": 9,
        "State with most events": "BC"
    },
    {
        "Events": 4,
        "State with least events": "MB"
    },
    {
        "Total Events": 21
    }
]
   ```
Un ulteriore esempio di body è:
   ```
{ 
	 "comparator": "segment", 
	 "elements": [
	 {
	  		 "name": "Arts" 
	   	}, 
	   	{
	   		 "name": "Music" 
	   	},
	   	{
	   		 "name": "Miscellaneous" 
	   	},
        {
	   		 "name": "Sports" 
	   	}

	   ],
	   "param": "state",
	   "value": "AB",
	   "period": 3
}
  ```
Otteniamo come response un JSONObject del seguente tipo:
  ```
[
    {
        "totalEvents": 122,
        "segment": "Arts"
    },
    {
        "totalEvents": 95,
        "segment": "Music"
    },
    {
        "totalEvents": 1,
        "segment": "Miscellaneous"
    },
    {
        "totalEvents": 20,
        "segment": "Sports"
    },
    {
        "totalEvents": 122,
        "Segment with most events": "Arts"
    },
    {
        "segment with least events": "Miscellaneous",
        "totalEvents": 1
    }
]
   ```

La rotta può generare le seguenti eccezioni: 
* WrongStateException: se si inserisce un stateCode diversi da quelli dell'elenco. Con output del tipo:
```
US non è un valore ammesso
```
* WrongPeriodException: se si inserisce un period diverso da 1, 3, 6 o 12
```
2 non è ammesso. Inserisci un period uguale a 1, 3, 6 o 12
```
* WrongValueException: se si inserisce un valore di param non ammeso.
```
Italian Rap non è un valore ammesso.
```
* WrongComparatorException: se viene inserito un comparator diverso da state, market, source, segment, genre o subgenre
```
states non è una stringa ammessa. Inserisci una stringa tra country, state, market, source, segment, genre o subgenre.
```

* WrongParameterException: se si inserisce un parametro diverso da state, segment, genre, subGenre, source.
```
genere non è accettato. Scegli tra: total, source, segment, genre e subgenre.
```

<a name=4></a>
## 4.   /saveEvents?stateCode=<stateCode>
La quarta rotta è di tipo GET e salverà all'interno di un file l'elenco di eventi aventi luogo nello Stato canadese iniserito dall'utente.
Per conoscere la lista degli stateCode ammessi si fa riferimento alla tabella presenta nella rotta numero [2](#2) ([/stateEvents](#2)).

#### Esempio

La rotta viene lanciata tramite un indirizzo di questo tipo: 
```
localhost:8080/saveEvents/?stateCode=CA
     
```
A cui seguirà il seguente output:
```
Il file è stato salvato in C:\Users\<Username>\ProgettoOOP\TicketmasterCanada/Important_events/CA_most_important_events.txt     
```
Il file conterrà le informazioni di questo tipo:
```
{
  "Evento": [
    {
      "address": "600 Block Hamilton St",
      "data": "2021-06-22",
      "orario": "20:00:00",
      "url": "http://www.ticketsnow.com/InventoryBrowse/TicketList.aspx?PID=2925225",
      "cityName": "Vancouver",
      "stateName": "British Columbia",
      "subgenre": "Musical",
      "countryCode": "CA",
      "segment": "Arts & Theatre",
      "name": "Hamilton",
      "genre": "Theatre",
      "stateCode": "BC",
      "id": "Z7r9jZ1Ae0PFP",
      "countryName": "Canada"
    },
    {
      "address": "600 Block Hamilton St",
      "data": "2021-06-23",
      "orario": "20:00:00",
      "url": "http://www.ticketsnow.com/InventoryBrowse/TicketList.aspx?PID=2925226",
      "cityName": "Vancouver",
      "stateName": "British Columbia",
      "subgenre": "Musical",
      "countryCode": "CA",
      "segment": "Arts & Theatre",
      "name": "Hamilton",
      "genre": "Theatre",
      "stateCode": "BC",
      "id": "Z7r9jZ1Ae0PFJ",
      "countryName": "Canada"
    },
    // OMISSIS
    {
      "address": "132 Front St E",
      "data": "2021-02-19",
      "orario": "14:00:00",
      "url": "https://www.universe.com/events/museum-of-illusions-february-19th-2021-tickets-toronto-X4ZGNC?ref=ticketmaster",
      "marketID": "102",
      "marketName": " Hamilton & Area\"",
      "cityName": "Toronto",
      "stateName": "Ontario",
      "subgenre": "Magic",
      "countryCode": "CA",
      "segment": "Arts & Theatre",
      "name": "Museum of Illusions - February 19th, 2021",
      "genre": "Magic & Illusion",
      "stateCode": "ON",
      "id": "LvZ189gneLW606Yvvu7vF",
      "countryName": "Canada"
    },
    {
      "address": "132 Front St E",
      "data": "2021-02-19",
      "orario": "13:00:00",
      "url": "https://www.universe.com/events/museum-of-illusions-february-19th-2021-tickets-toronto-X4ZGNC?ref=ticketmaster",
      "marketID": "102",
      "marketName": " Hamilton & Area\"",
      "cityName": "Toronto",
      "stateName": "Ontario",
      "subgenre": "Magic",
      "countryCode": "CA",
      "segment": "Arts & Theatre",
      "name": "Museum of Illusions - February 19th, 2021",
      "genre": "Magic & Illusion",
      "stateCode": "ON",
      "id": "LvZ189gneLW606Yvvu7vZ",
      "countryName": "Canada"
    }
  ]
}     
```

La rotta può generare la seguente eccezione: 
* WrongStateException: se si inserisce un stateCode diversi da quelli dell'elenco
```
US non è un valore ammesso
```

 
 <a name="rotteaggiuntive"></a>
## Rotte Aggiuntive

Inoltre il nostro programma offre funzionalità aggiuntive. Infatti, se l'utente vuole conoscere le statistiche di una qualsiasi città che non è presente nello storico, può farlo ma limitatamente a un giorno o a cinque giorni. Oltre alle informazioni sulla visibilità, sarà possibile richiedere anche previsioni e statistiche su temperatura massima, minima e percepita, attraverso le seguenti rotte:

N° | Tipo | Rotta | Descrizione
----- | ------------ | -------------------- | ----------------------
[5](#5) | ` GET ` | `/marketEvents?marketID=<marketID>` | *Restituisce un JSONObject con gli eventi, insieme alle relative informazioni, in programma nello Market canadese passato come parametro.*
[6](#6) | ` GET ` | `/sourceEvents?source=<source>&stateCode=<stateCode>` | *Restituisce un JSONObject con gli eventi, insieme alle relative informazioni, che hanno come source il parametro indicato dall'utente, in programma nello Stato canadese passato come parametro. Se l'utente inserisce lo stateCode = CA si visualizzano gli eventi dell'intero Canada.*
[7](#7) | ` GET ` | `/keywordEvents?keyword=<keyword>&stateCode=<stateCode>` | *Restituisce un JSONObject con gli eventi, insieme alle relative informazioni, a partire dalla parola chiave indicato dall'utente, in programma nello Stato canadese passato come parametro. Se l'utente inserisce lo stateCode = CA si visualizzano gli eventi dell'intero Canada.*
[8](#8) | ` GET ` | `/segmentEvents?segment=<segment>&stateCode=<stateCode>` | *Restituisce un JSONObject con gli eventi, insieme alle relative informazioni, che hanno come tipologia dell'evento il parametro indicato dall'utente, in programma nello Stato canadese passato come parametro. Se l'utente inserisce lo stateCode = CA si visualizzano gli eventi dell'intero Canada.*
[9](#9) | ` GET ` | `/genreEvents?genre=<genre>&stateCode=<stateCode>` | *Restituisce un JSONObject con gli eventi, insieme alle relative informazioni, che hanno come genere dell'evento il parametro indicato dall'utente, in programma nello Stato canadese passato come parametro. Se l'utente inserisce lo stateCode = CA si visualizzano gli eventi dell'intero Canada.*
[10](#10) | ` GET ` | `/subgenreEvents?subgenre=<subgenre>&stateCode=<stateCode>` | *Restituisce un JSONObject con gli eventi, insieme alle relative informazioni, che hanno come sottogenere dell'evento il parametro indicato dall'utente, in programma nello Stato canadese passato come parametro. Se l'utente inserisce lo stateCode = CA si visualizzano gli eventi dell'intero Canada.*




<a name=5></a>
## 5.   /marketEvents?marketID=<marketID>

Questa rotta restituisce gli eventi aventi luogo nel market canadese inserito dall'utente come paramentro.
I market vanno inseriti sotto forma di una stringa di tre cifre seguendo la seguente tabella:

N° | Market | marketID 
----- | ------------ | -------------------- 
1| `Toronto, Hamilton & Area` | `102` 
2| `Ottawa & Eastern Ontario ` | `103` 
3| `Manitoba ` | `106` 
4| `Edmonton & Northern Alberta` | `107` 
5| `Calgary & Southern Alberta` | `108` 
6| `B.C. Interior` | `110` 
7| `Vancouver & Area` | `111` 
8| `Saskatchewan` | `112` 
9| `Montréal & Area` | `120`

### Esempio

La rotta viene lanciata tramite un indirizzo di questo tipo: 
```
localhost:8080/marketEvents?marketID=102

```
Otteniamo come response un JSONObject del seguente tipo:
```
{
    "Evento": [
        {
            "address": "35 Woolwich St",
            "data": "2021-09-24",
            "orario": "20:00:00",
            "url": "http://riverrun.ca/whats-on/live-nation-presents-home-free/",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Guelph",
            "stateName": "Ontario",
            "subgenre": "Country",
            "countryCode": "CA",
            "segment": "Music",
            "name": "Home Free: Dive Bar Saints World Tour",
            "genre": "Country",
            "stateCode": "ON",
            "id": "117Zv97a1Zkvvu",
            "countryName": "Canada"
        },
        {
            "address": "1 Yonge St.",
            "data": "2021-02-19",
            "orario": "21:00:00",
            "url": "https://www.universe.com/events/immersive-van-gogh-drive-in-preview-19th-february-tickets-9PQ026?ref=ticketmaster",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Fine Art",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Immersive Van Gogh - DRIVE IN PREVIEW - 19th February",
            "genre": "Fine Art",
            "stateCode": "ON",
            "id": "LvZ189Xa1SjllnZvv8r_G",
            "countryName": "Canada"
        },
        //OMISSIS
        {
            "address": "132 Front St E",
            "data": "2021-03-04",
            "orario": "18:00:00",
            "url": "https://www.universe.com/events/museum-of-illusions-march-4th-2021-tickets-toronto-71SKGW?ref=ticketmaster",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Magic",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Museum of Illusions - March 4th, 2021",
            "genre": "Magic & Illusion",
            "stateCode": "ON",
            "id": "LvZ189gnelRwaX8ZRmAsm",
            "countryName": "Canada"
        },
        {
            "address": "132 Front St E",
            "data": "2021-03-04",
            "orario": "15:00:00",
            "url": "https://www.universe.com/events/museum-of-illusions-march-4th-2021-tickets-toronto-71SKGW?ref=ticketmaster",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Magic",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Museum of Illusions - March 4th, 2021",
            "genre": "Magic & Illusion",
            "stateCode": "ON",
            "id": "LvZ189gnelRwaX8ZRmAsp",
            "countryName": "Canada"
        }
    ]
}
```
* WrongValueException: viene richiamato quando si inserisce un marketID non canadese, cioè diverso dai nove nella tabella.
```
118 non è un valore ammesso
```

<a name=6></a>
## 6.   /sourceEvents?source=<source>&stateCode=<stateCode>

Questa rotta restituisce un JSONObject con gli eventi aventi come distributore il source e come luogo lo Stato inseriti dall'utente. 
I source ammessi sono i seguenti:
N° | source 
----- | ------------ 
1| `ticketmaster` 
2| `universe ` 
3| `tmr ` 
4| `frontgate ` 


Per conoscere la lista degli stateCode ammessi si fa riferimento alla tabella presenta nella rotta numero [2](#2) ([/stateEvents](#2)).

### Esempio

La rotta viene lanciata tramite un indirizzo di questo tipo: 
```
localhost:8080/sourceEvents?source=universe&stateCode=ON

```
Otteniamo come response un JSONObject del seguente tipo:
```
 {
    "Evento": [
        {
            "address": "1 Yonge St.",
            "data": "2021-02-19",
            "orario": "21:00:00",
            "url": "https://www.universe.com/events/immersive-van-gogh-drive-in-preview-19th-february-tickets-9PQ026?ref=ticketmaster",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Fine Art",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Immersive Van Gogh - DRIVE IN PREVIEW - 19th February",
            "genre": "Fine Art",
            "stateCode": "ON",
            "id": "LvZ189Xa1SjllnZvv8r_G",
            "countryName": "Canada"
        },
        {
            "address": "1 Yonge St.",
            "data": "2021-02-19",
            "orario": "12:00:00",
            "url": "https://www.universe.com/events/illusionarium-off-peak-tickets-S960ZQ?ref=ticketmaster",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Magic",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Illusionarium (Off-Peak)",
            "genre": "Magic & Illusion",
            "stateCode": "ON",
            "id": "LvZ189XdEvwW0_YZvhBl-",
            "countryName": "Canada"
        },
        //OMISSIS
     {
            "address": "1 Yonge St.",
            "data": "2021-03-05",
            "orario": "14:00:00",
            "url": "https://www.universe.com/events/immersive-van-gogh-drive-in-preview-5th-march-tickets-JKDQP3?ref=ticketmaster",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Fine Art",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Immersive Van Gogh - DRIVE IN PREVIEW - 5th March /",
            "genre": "Fine Art",
            "stateCode": "ON",
            "id": "LvZ189Hfqz1nCUYZgPYfC",
            "countryName": "Canada"
        }
    ]
}
```
La rotta può generare le seguenti eccezioni: 
* WrongStateException: se si inserisce un stateCode di uno Stato non canadese.
```
GB non è un valore ammesso
```
* WrongValueException: se si inserisce un source diversi da quelli ammessi.
```
universal non è un valore ammesso
```


<a name=7></a>
## 7.    /keywordEvents?keyword=<keyword>&stateCode=<stateCode>

Questa rotta restituisce un JSONObject con gli eventi a partire dalla parola chiave inserita e avente come luogo lo Stato inserito dall'utente. 
Per conoscere la lista degli stateCode ammessi si fa riferimento alla tabella presenta nella rotta numero [2](#2) ([/stateEvents](#2)).

### Esempio

La rotta viene lanciata tramite un indirizzo di questo tipo: 
```
localhost:8080/keywordEvents?keyword=Van Gogh&stateCode=ON
```
Otteniamo come response un JSONObject del seguente tipo:
 ```
{
    "Evento": [
        {
            "address": "1 Yonge St.",
            "data": "2021-02-19",
            "orario": "21:00:00",
            "url": "https://www.universe.com/events/immersive-van-gogh-drive-in-preview-19th-february-tickets-9PQ026?ref=ticketmaster",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Fine Art",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Immersive Van Gogh - DRIVE IN PREVIEW - 19th February",
            "genre": "Fine Art",
            "stateCode": "ON",
            "id": "LvZ189Xa1SjllnZvv8r_G",
            "countryName": "Canada"
        },
        {
            "address": "1 Yonge St.",
            "data": "2021-02-22",
            "orario": "10:00:00",
            "url": "https://www.universe.com/events/immersive-van-gogh-drive-in-preview-22nd-feb-tickets-32VF0N?ref=ticketmaster",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Fine Art",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Immersive Van Gogh - DRIVE IN PREVIEW - 22nd Feb",
            "genre": "Fine Art",
            "stateCode": "ON",
            "id": "LvZ189H7_3tn2COZI4JQj",
            "countryName": "Canada"
        },
        //OMISSIS
      {
            "address": "1 Yonge St.",
            "data": "2021-03-13",
            "orario": "16:00:00",
            "url": "https://www.universe.com/events/immersive-van-gogh-drive-in-preview-13th-mar-tickets-T0387J?ref=ticketmaster",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Fine Art",
            "countryCode": "CA",
            "segment": "Arts & Theatre",
            "name": "Immersive Van Gogh - DRIVE IN PREVIEW - 13th MAR /",
            "genre": "Fine Art",
            "stateCode": "ON",
            "id": "LvZ189H7_ZmDVOYvvLhQc",
            "countryName": "Canada"
        }
    ]
}

 ```
La rotta può generare la seguente eccezione: 
* WrongStateException: se si inserisce un stateCode di uno Stato non canadese.
```
GB non è un valore ammesso
```

 
 <a name=8></a>
## 8.    /segmentEvents?segment=<segment>&stateCode=<stateCode>
Restituisce un JSONObject con gli eventi, insieme alle relative informazioni, che hanno come tipologia dell’evento il parametro indicato dall’utente, in programma nello Stato canadese passato come parametro.
Nel paramentro segment si possono  utilizzare sia i seguenti segmentName, sia i corrispondenti segmentId:
segmentName | segmentId 
----- | ------------ 
`Sports`| `KZFzniwnSyZfZ7v7nE` 
`Arts`| `KZFzniwnSyZfZ7v7na` 
`Music`|  `KZFzniwnSyZfZ7v7nJ` 
`Miscellaneous`|  `KZFzniwnSyZfZ7v7n1`


Se si è a conoscenza di ulteriori segmentId, questi possono essere utilizzati come parametro. Non è però ammesso l'utilizzo di altri segmentName al di fuori di quelli sopracitati, in quanto l'applicazione non è in grado di convertirli. 
Per conoscere la lista degli stateCode ammessi si fa riferimento alla tabella presenta nella rotta numero [2](#2) ([/stateEvents](#2)).

### Esempio

La rotta viene lanciata tramite un indirizzo di questo tipo: 
```
localhost:8080/segmentEvents?segment=Music&stateCode=ON
```
-oppure-
```
localhost:8080/segmentEvents?segment=KZFzniwnSyZfZ7v7nJ&stateCode=ON
```
Dove "KZFzniwnSyZfZ7v7nJ" è il segmentId che corrisponde al segmentName "Music".
Otteniamo come response un JSONObject del seguente tipo:
 ```
{
    "Evento": [
        {
            "address": "99 Dundas Street",
            "data": "2021-08-26",
            "orario": "19:30:00",
            "url": "https://budweisergardens.evenue.net/cgi-bin/ncommerce3/SEGetEventList?groupCode=DB&linkID=global-labatt&RSRC=WEB_PRO&RDAT=BG21G18",
            "cityName": "London",
            "stateName": "Ontario",
            "subgenre": "Pop",
            "countryCode": "CA",
            "segment": "Music",
            "name": "The Doobie Brothers - 50th Anniversary Tour",
            "genre": "Rock",
            "stateCode": "ON",
            "id": "1k7Zv9r9GA2vsly",
            "countryName": "Canada"
        },
        {
            "address": "35 Woolwich St",
            "data": "2021-09-24",
            "orario": "20:00:00",
            "url": "http://riverrun.ca/whats-on/live-nation-presents-home-free/",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Guelph",
            "stateName": "Ontario",
            "subgenre": "Country",
            "countryCode": "CA",
            "segment": "Music",
            "name": "Home Free: Dive Bar Saints World Tour",
            "genre": "Country",
            "stateCode": "ON",
            "id": "117Zv97a1Zkvvu",
            "countryName": "Canada"
        },
        //OMISSIS
         {
            "address": "147 Danforth Ave.",
            "data": "2021-12-01",
            "orario": "18:00:00",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.ca/all-distortions-are-intentional-tour-toronto-ontario-12-01-2021/event/10005863F6D4778D",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Pop",
            "countryCode": "CA",
            "segment": "Music",
            "minPrice": 35,
            "name": "All Distortions Are Intentional Tour",
            "genre": "Rock",
            "stateCode": "ON",
            "currency": "CAD",
            "id": "1A8ZA-NGkdUg6ru",
            "countryName": "Canada",
            "maxPrice": 45,
            "info": "All Ages Event Doors - 6:00pm"
        },
        {
            "address": "6408 Stanley Ave",
            "data": "2021-12-10",
            "orario": "21:00:00",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.ca/reo-speedwagon-niagara-falls-ontario-12-10-2021/event/1000584CF05F61A8",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Niagara Falls",
            "stateName": "Ontario",
            "subgenre": "Pop",
            "countryCode": "CA",
            "segment": "Music",
            "minPrice": 33.9,
            "name": "REO Speedwagon",
            "genre": "Rock",
            "stateCode": "ON",
            "currency": "CAD",
            "id": "1AvZZp7GkSY9UkI",
            "countryName": "Canada",
            "maxPrice": 62.15
        }
    ]
}
 ```
La rotta può generare le seguenti eccezioni: 
* WrongStateException: se si inserisce un stateCode di uno Stato non canadese.
```
GB non è un valore ammesso
```
* WrongValueException: se si inserisce un segment diverso da quelli ammessi.
```
Sport non è un valore ammesso
```

<a name=9></a>
## 9.    /genreEvents?genre=<genre>&stateCode=<stateCode>
Restituisce un JSONObject con gli eventi, insieme alle relative informazioni, che hanno come genere dell’evento il parametro indicato dall’utente, in programma nello Stato canadese passato come parametro.
Nel paramentro genre si possono  utilizzare sia i seguenti Genre, sia i corrispondenti genreId:
Genre| genreId 
----- | ------------ 
`Alternative` | `KnvZfZ7vAvv `
 `	Aquatics`  | ` KnvZfZ7vAeI`
 `	Athletic Races` | ` KnvZfZ7vAet`
 `	Basketball`  | ` KnvZfZ7vAde`
 `	Blues`  | ` KnvZfZ7vAvd`
 `	Boxing`  | ` KnvZfZ7vAdA`
 `	Children's Theatre` | ` KnvZfZ7v7na`
 `	Circus & Specialty Acts`  | ` KnvZfZ7v7n1`
 `	Classical`  | ` KnvZfZ7vAeJ`
 `	Comedy`| ` KnvZfZ7vAe1`
 `	Community/Civic` | ` KnvZfZ7vAAE`
 `	Country ` | ` KnvZfZ7vAv6`
 `	Cricket ` | ` KnvZfZ7vAdk`
 `	Cycling ` | ` KnvZfZ7vAda`
 `	Dance`| ` KnvZfZ7v7nI`
 `	Dance/Electronic`  | ` KnvZfZ7vAvF`
 `	Equestrian`  | ` KnvZfZ7vAd1`
 `	Family`  | ` KnvZfZ7vA1n`
 `	Fashion ` | ` KnvZfZ7v7nn`
 `	Folk ` | ` KnvZfZ7vAva`
 `	Hip-Hop/Rap ` | ` KnvZfZ7vAv1`
 `	Hobby/Special Interest Expos ` | ` KnvZfZ7vAAJ`
 `	Ice Shows ` | ` KnvZfZ7v7lI`
 `	Jazz ` | ` KnvZfZ7vAvE`
 `	Magic & Illusion ` | ` KnvZfZ7v7lv`
 `	Martial Arts ` | ` KnvZfZ7vA7d`
`	Metal ` | ` KnvZfZ7vAvt`
`	Miscellaneous ` | ` KnvZfZ7vA7A`
`	Miscellaneous Theatre ` | ` KnvZfZ7v7ld`
`	Motorsports/Racing ` | ` KnvZfZ7vA7k`
`	Performance Art ` | ` KnvZfZ7v7l6`
`	Pop ` | ` KnvZfZ7vAev`
`	Reggae ` | ` KnvZfZ7vAed`
`	Rock ` | ` KnvZfZ7vAeA`
`	Rugby ` | ` KnvZfZ7vA71`
`	R&B ` | ` KnvZfZ7vAee`
`	Spectacular ` | ` KnvZfZ7v7la`
`	Theatre ` | ` KnvZfZ7v7l1`
`	Undefined ` | ` KnvZfZ7v7ll`
`	Variety ` | ` KnvZfZ7v7lJ	`
`	Volleyball ` | ` KnvZfZ7vAA7`
`	World ` | ` KnvZfZ7vAeF`
`	Wrestling ` | ` KnvZfZ7vAAk`
	
	
Se si è a conoscenza di ulteriori genreId, questi possono essere utilizzati come parametro. Non è però ammesso l'utilizzo di altri genreName al di fuori di quelli sopracitati, in quanto l'applicazione non è in grado di convertirli.
Per conoscere la lista degli stateCode ammessi si fa riferimento alla tabella presenta nella rotta numero [2](#2) ([/stateEvents](#2)).

### Esempio 

La rotta viene lanciata tramite un indirizzo di questo tipo: 
```
localhost:8080/genreEvents?genre=Rock&stateCode=ON
```
-oppure-
```
localhost:8080/genreEvents?genre=KnvZfZ7vAeA&stateCode=ON
```
Dove "KnvZfZ7vAeA" è il genreId che corrisponde a "Rock".

Otteniamo come response un JSONObject del seguente tipo:
 ```
{
    "Evento": [
        {
            "address": "99 Dundas Street",
            "data": "2021-08-26",
            "orario": "19:30:00",
            "url": "https://budweisergardens.evenue.net/cgi-bin/ncommerce3/SEGetEventList?groupCode=DB&linkID=global-labatt&RSRC=WEB_PRO&RDAT=BG21G18",
            "cityName": "London",
            "stateName": "Ontario",
            "subgenre": "Pop",
            "countryCode": "CA",
            "segment": "Music",
            "name": "The Doobie Brothers - 50th Anniversary Tour",
            "genre": "Rock",
            "stateCode": "ON",
            "id": "1k7Zv9r9GA2vsly",
            "countryName": "Canada"
        },
        {
            "address": "5555A Dundas St. West",
            "data": "2021-02-27",
            "orario": "20:00:00",
            "url": "https://www.ticketweb.ca/event/who-made-who-acdc-the-rockpile-west-tickets/10712085",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Hard Rock",
            "countryCode": "CA",
            "segment": "Music",
            "minPrice": 24.35,
            "name": "Who Made Who / AC/DC Tribute",
            "genre": "Rock",
            "stateCode": "ON",
            "currency": "CAD",
            "id": "rZ7HnEZ1A8j3eA",
            "countryName": "Canada",
            "maxPrice": 24.35
        },
        //OMISSIS
        {
            "address": "147 Danforth Ave.",
            "data": "2022-04-12",
            "orario": "19:00:00",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.ca/the-airborne-toxic-event-toronto-ontario-04-12-2022/event/1000576FA6233D34",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Alternative Rock",
            "countryCode": "CA",
            "segment": "Music",
            "minPrice": 27.5,
            "name": "The Airborne Toxic Event",
            "genre": "Rock",
            "stateCode": "ON",
            "currency": "CAD",
            "id": "1AvZZ4UGkXJFSVV",
            "countryName": "Canada",
            "maxPrice": 40,
            "info": "19+ Event/Valid Photo ID Required Doors - 7:00pm"
        },
        {
            "address": "6408 Stanley Ave",
            "data": "2022-05-06",
            "orario": "19:30:00",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.ca/zz-top-with-special-guest-cheap-niagara-falls-ontario-05-06-2022/event/1000584CE95D5EFB",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Niagara Falls",
            "stateName": "Ontario",
            "subgenre": "Pop",
            "countryCode": "CA",
            "segment": "Music",
            "minPrice": 67.8,
            "name": "ZZ Top with Special Guest Cheap Trick",
            "genre": "Rock",
            "stateCode": "ON",
            "currency": "CAD",
            "id": "1AvZZp7GkSt94DD",
            "countryName": "Canada",
            "maxPrice": 96.05
        }
		
    ]
}
 ```
La rotta può generare le seguenti eccezioni: 
* WrongStateException: se si inserisce un stateCode di uno Stato non canadese.
```
GB non è un valore ammesso
```
* WrongValueException: se si inserisce un genre diverso da quelli ammessi.
```
Italian Rap non è un valore ammesso
```

<a name=1O></a>
## 10.    /subgenreEvents?subgenre=<subgenre>&stateCode=<stateCode>
Restituisce un JSONObject con gli eventi, insieme alle relative informazioni, che hanno come sottogenere dell’evento il parametro indicato dall’utente, in programma nello Stato canadese passato come parametro.
SubGenre| subGenreId 
----- | ------------
`Adult Contemporary ` | ` KZazBEonSMnZfZ7vk1l`
`Alternative ` | ` KZazBEonSMnZfZ7vAvJ`
`Alternative Rock ` | ` KZazBEonSMnZfZ7v6dt`
`Aquatics ` | ` KZazBEonSMnZfZ7vF1a`
`Athletic Races ` | ` KZazBEonSMnZfZ7vF11`
`Blues ` | ` KZazBEonSMnZfZ7vAAd`
`Blues` | `Rock ` | ` KZazBEonSMnZfZ7v676`
`Boxing ` | ` KZazBEonSMnZfZ7vFJJ`
`British Folk` | `Rock ` | ` KZazBEonSMnZfZ7v671`
`Burlesque ` | ` KZazBEonSMnZfZ7vaaE`
`Cabaret ` | ` KZazBEonSMnZfZ7vAv7`
`Children's Theatre ` | ` KZazBEonSMnZfZ7v7na`
`Circus ` | ` KZazBEonSMnZfZ7v7n1`
`Classical/Vocal ` | ` KZazBEonSMnZfZ7vF1A`
`Club Dance ` | ` KZazBEonSMnZfZ7vAJ1`
`Comedy ` | ` KZazBEonSMnZfZ7vF17`
`Community/Civic ` | ` KZazBEonSMnZfZ7vFlv`
`Country ` | ` KZazBEonSMnZfZ7vAFa`
`Cricket ` | ` KZazBEonSMnZfZ7vFJE`
`Cycling ` | ` KZazBEonSMnZfZ7vFEv`
`Dance ` | ` KZazBEonSMnZfZ7v7nl`
`Disco ` | ` KZazBEonSMnZfZ7vAJn`
`Drama ` | ` KZazBEonSMnZfZ7v7lt`
`Dressage ` | ` KZazBEonSMnZfZ7vFEe`
`Equestrian ` | ` KZazBEonSMnZfZ7vFEd`
`European Pop ` | ` KZazBEonSMnZfZ7v6At`
`Fashion ` | ` KZazBEonSMnZfZ7v7le`
`Folk ` | ` KZazBEonSMnZfZ7vAn7`
`French Rap ` | ` KZazBEonSMnZfZ7vaa1`
`Hard Rock ` | ` KZazBEonSMnZfZ7v6kl`
`Heavy Metal ` | ` KZazBEonSMnZfZ7vkFd`
`Hobby/Special Interest Expos ` | ` KZazBEonSMnZfZ7vFnl`
`Ice Shows ` | ` KZazBEonSMnZfZ7vAv6`
`Indie Pop ` | ` KZazBEonSMnZfZ7vkEk`
`Indie Rock ` | ` KZazBEonSMnZfZ7vAde`
`Jazz ` | ` KZazBEonSMnZfZ7vkda`
`Latin ` | ` KZazBEonSMnZfZ7vFdJ`
`Magic ` | ` KZazBEonSMnZfZ7v7l7`
`Men Professional ` | ` KZazBEonSMnZfZ7vFJ6`
`Metalcore ` | ` KZazBEonSMnZfZ7vaJk`
`Miscellaneous ` | ` KZazBEonSMnZfZ7vFIt`
`Miscellaneous Theatre ` | ` KZazBEonSMnZfZ7v7lk`
`Mixed Martial Arts ` | ` KZazBEonSMnZfZ7vFIE`
`MLB ` | ` KZazBEonSMnZfZ7vF1n`
`Nu-Metal ` | ` KZazBEonSMnZfZ7vaJ6`
`Other ` | ` KZazBEonSMnZfZ7vaav`
`Performance Art ` | ` KZazBEonSMnZfZ7v7l1`
`Pop ` | ` KZazBEonSMnZfZ7v6F1`
`Rap-Rock ` | ` KZazBEonSMnZfZ7vkel`
`Reggae ` | ` KZazBEonSMnZfZ7vknl`
`Rugby Union ` | ` KZazBEonSMnZfZ7vFtJ`
`Rock ` | ` KZazBEonSMnZfZ7v6da`
`Rock & Roll ` | ` KZazBEonSMnZfZ7v6an`
`R&B ` | ` KZazBEonSMnZfZ7vkIt`
`Scandinavia ` | ` KZazBEonSMnZfZ7vF6E`
`Soul ` | ` KZazBEonSMnZfZ7vknE`
`Southern Rock ` | ` KZazBEonSMnZfZ7v61J`
`Spectacular ` | ` KZazBEonSMnZfZ7v7lE`
`Undefined ` | ` KZazBEonSMnZfZ7vAv1`
`Urban ` | ` KZazBEonSMnZfZ7vkdA`
`Variety ` | ` KZazBEonSMnZfZ7vAvA`
`Volleyball ` | ` KZazBEonSMnZfZ7vFn6`
`Witchstep ` | ` KZazBEonSMnZfZ7va1k`
`World ` | ` KZazBEonSMnZfZ7v6Jt`
`Wrestling ` | ` KZazBEonSMnZfZ7vFna`
	
	
	
Se si è a conoscenza di ulteriori subGenreId, questi possono essere utilizzati come parametro. Non è però ammesso l'utilizzo di altri subGenreName al di fuori di quelli sopracitati, in quanto l'applicazione non è in grado di convertirli.
Per conoscere la lista degli stateCode ammessi si fa riferimento alla tabella presenta nella rotta numero [2](#2) ([/stateEvents](#2)).

### Esempio

La rotta viene lanciata tramite un indirizzo di questo tipo: 
```
localhost:8080/subgenreEvents?subgenre=Pop&stateCode=ON
```
-oppure-
```
localhost:8080/subgenreEvents?subgenre=KZazBEonSMnZfZ7v6F1&stateCode=ON
```
Dove "KZazBEonSMnZfZ7v6F1" è il subGenreId che corrisponde a "Pop".

Otteniamo come response un JSONObject del seguente tipo:
 ```
{
    "Evento": [
        {
            "address": "99 Dundas Street",
            "data": "2021-08-26",
            "orario": "19:30:00",
            "url": "https://budweisergardens.evenue.net/cgi-bin/ncommerce3/SEGetEventList?groupCode=DB&linkID=global-labatt&RSRC=WEB_PRO&RDAT=BG21G18",
            "cityName": "London",
            "stateName": "Ontario",
            "subgenre": "Pop",
            "countryCode": "CA",
            "segment": "Music",
            "name": "The Doobie Brothers - 50th Anniversary Tour",
            "genre": "Rock",
            "stateCode": "ON",
            "id": "1k7Zv9r9GA2vsly",
            "countryName": "Canada"
        },
        {
            "address": "1 Elgin",
            "data": "2021-03-20",
            "orario": "20:00:00",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.ca/louisjean-cormier-ottawa-ontario-03-20-2021/event/31005764946D1761",
            "marketID": "103",
            "marketName": "Ottawa and Eastern Ontario",
            "cityName": "Ottawa",
            "stateName": "Ontario",
            "subgenre": "Pop",
            "countryCode": "CA",
            "segment": "Music",
            "minPrice": 15,
            "name": "Louis-Jean Cormier",
            "genre": "Rock",
            "stateCode": "ON",
            "currency": "CAD",
            "id": "16sZAq0PkZACeF6e",
            "countryName": "Canada",
            "maxPrice": 45
        },
        //OMISSIS
        {
            "address": "50 Bay Street, Suite 500",
            "data": "2022-02-15",
            "orario": "20:00:00",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.ca/elton-john-farewell-yellow-brick-road-toronto-ontario-02-15-2022/event/10005710ED53519C",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Toronto",
            "stateName": "Ontario",
            "subgenre": "Pop",
            "countryCode": "CA",
            "segment": "Music",
            "minPrice": 65.5,
            "name": "Elton John: Farewell Yellow Brick Road",
            "genre": "Rock",
            "stateCode": "ON",
            "currency": "CAD",
            "id": "1A8ZAj8Gkdcfgkj",
            "countryName": "Canada",
            "maxPrice": 245.5,
            "info": "Floor Seats are not Wheelchair Accessible"
        },
        {
            "address": "6408 Stanley Ave",
            "data": "2022-05-06",
            "orario": "19:30:00",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.ca/zz-top-with-special-guest-cheap-niagara-falls-ontario-05-06-2022/event/1000584CE95D5EFB",
            "marketID": "102",
            "marketName": " Hamilton & Area\"",
            "cityName": "Niagara Falls",
            "stateName": "Ontario",
            "subgenre": "Pop",
            "countryCode": "CA",
            "segment": "Music",
            "minPrice": 67.8,
            "name": "ZZ Top with Special Guest Cheap Trick",
            "genre": "Rock",
            "stateCode": "ON",
            "currency": "CAD",
            "id": "1AvZZp7GkSt94DD",
            "countryName": "Canada",
            "maxPrice": 96.05
        }
    ]
}

 ```
La rotta può generare le seguenti eccezioni: 
* WrongStateException: se si inserisce un stateCode di uno Stato non canadese.
```
GB non è un valore ammesso
```
* WrongValueException: se si inserisce un subgenre diverso da quelli ammessi.
```
Rokc non è un valore ammesso
```


<a name="test"></a>
## Test
Abbiamo implementato i seguenti test all'interno del nostro programma:

 * Test - it.unvpm.TicketmasterCanada.files

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Tests/FilesTest.jpg)

* Test - it.unvpm.TicketmasterCanada.stats

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Tests/StatsTest.jpg)

* Test - it.unvpm.TicketmasterCanada.filters

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Tests/TestFilters.jpg)

* Test - it.unvpm.TicketmasterCanada.service

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Tests/TestService.jpg)

* Test completo

![alt_text](https://github.com/FabioCarosi/ProgettoOOP/blob/master/TicketmasterCanada/UML/Tests/TestCompleto.jpg)



<a name="doc"></a>
## Documentazione
Il codice java è interamente documentato in [Javadoc](https://github.com/FabioCarosi/ProgettoOOP/tree/master/TicketmasterCanada/doc).

<a name="autor"></a>
### Autori
Progetto realizzato da:
- Fabio Carosi (50%)
- Mattia Girolami (50%)

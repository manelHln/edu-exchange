import {React, useState  } from "react";
import {activeIcon,user} from "@/assets/images";

const ActiveIcon = () => {
    return  <div className="iconFrame">
    <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAkFBMVEU0wwD///85xQD6/vnz/PD8/vv3/fXw++z4/fbt+uj1/PI8xgDx++101lHZ9M/+//2F22bi99ux6J2+7K7M8L9+2V1JyRpj0Tu46qaN3XDm+OBs1Eei5IpTzCdZzi6A2WCK3G2q5pS766rE7rXR8sab4oKy6J+k5I3b9dJ52Fdv1EqW4HzC7bLj99zV88rJ8Lzgzg5OAAAJJklEQVR4nOWd2ZaqMBBFQ5iJiGILCuLUtnPr///dDaJXROZBSPV59MHFXqkpCVQhrkkZoiIJw/NsOhjrrj33LIwQtry57erjwXQ22guSIhqNPgKHmvpjUdLk/Xm3PHqWhQOhp4IfLMtzl7vRXtYksannaIZQVIThZOp6FnnBihXGxLLc5XYvKM1Q1k4oSj6dTeGy2F45LZtS9hpYy3oJRe1Gl71yKZQaX+sj1UlI8VZ6SboQ5XE11OpcyboIRcnZHqxKdA8RSzed+iBrIRQldb3wqq3ei7A1njg1+WQNhEbvPPCKBZYcjMQbjOQ6UmVlQlH4rsk63yH1c6/6OlYkFOX10WoCLxBxJ3JVxkqEvGrapDm+G6O9VauljwqEorpqmi9gXDlV1rE8obD+BN+NcT7pfZ5QuYwb9L83xsNF+Syhof40Ez+ThK1ZWVMtRaidP2WgTxF7JHyKkN8PPmigIcbFvoypFieUV95HDfQp7O3U5gnFvv5xA32KuJfCybEgobaet8fny9sW9cZChIYzbcUDwyJTp1g9XoSQv7gtWuhD2N0UstQChNrWa5sukGcWKXFyExrOsgMLGIgMClhqXkJxY7eUI+KE7a/clpqTUBl1xEIf8kZ5s38+QmnSegyNyjK1Ggm1XecAqTPO8sWbPIS9U2diTFhkmquGy0GoDjoJ6JfiTh2Exu+hQ0H0VVgfZmeNTMK921lAP2vsMxGzCH/dtinSZQ8rEjrdNdG79CxfTCeUF10HRHicEVFTCYVpR6NoWGQqlybUZgwAUsRTaupPIVRWHaxk4kR2aQVcMiG/ZgSQ1qhbqQSh+N2x3USarHXyZiqRsN/ykVMxeZvEzJ9EKOttP3QxuYk5I4FQYiOMPoVPSaeM8YTiNzNR5iGS5IrxhHumnDDQvF+AUO58NRonPd4V4wiVHWNOGIjMYhN/DKFxZc4JA1nfcZeoMYSO3fajltU8brP4Tih189wpj/A0xk7fCI0vRm3Ul/X1Xtq8EfaObT9mFcXE0yihaDJro77I6u2wP0roMJjrw/Legk2EUDqxmOtDeg82r4RMh5lAb8HmlZDtMBMoGmxeCMUt02EmUDTYvBCqzFYzYc2dRELGM8VDeMUnEfZALCFCtppAKK5BLCH1xC0fTygACKSBXo6lnoQGe2czSSIjMY5QO7T9YPVJ78UQAihnniKh3f5/Qm3AeEX6onHvjdC4AFpCWp0+T/kfhMoU0hIitNSihCrj+8KoPCdCKJ6BZPuHyFp8JZSWsIwUoYXwSugwdB2aT9bwhVDcQltChE0+TKgxeRWTrkMvTDgElQwDWfsQIb+Ct4QIz5QnodDx1/PKyZb/EwKr2B4iQeWGoBrpfzP1CbUxSEKkCw9CGVy6D2Spd0JjA9INqSPeDvgRWDf0HVEKCCWgbng/rkFw3ZA6onMjBOuGd0dE1A2BbX6fwjvFJ4SaDX3522DE9cC6IUKe6hM6YN2QOiLd6CPAgSYINUicwHVDhCc8h/gfyIQ/EocUUPcVUdFgiiSQ+/uH6D4fCYCTxW0DhSAesz1F0wWCc7cdJ3I1ENyq1Bde8QhysvDThYKA3YxGhKcS6v6XvlWElxoCvHeiwgMN6aAJ0UFDXW6ZUIOOAgL2hkJUdg+BLtpuhKBLGoTmMnRCS277CZoWUdt+gqZFCeFbKXBCT4aeLWgshZ/xQR9E3aq2I+y69AB+b7HQoO+A6f4Q/ikG65/Fpss/iYJ/mngGXdSQkQj9VL//F25m4N+uwb4hHQt/4ZYb9psKWx762yZX4y+8McT1AO+Bg7e+IL+5579Cizh+B5bQD6W3N2jB1t7kKt7eglbB1m33t6A5CeCneYEOwv1rBKiOiG+9eBCwbgphBZ92+V8FQXVET4X+Zdf4/5ddQB0xcMM/8oUloO5CYbnPr2RhfjZzN9L71+p7gGZKhtA7DugvHQdAtBN8Fd6+dI2A2PnjN9K9BdyZ4jjSvUUcATPTtw484LooWdEuSn+gExawyo18vXUz4zRQF/oxHenYnRcQp9AShjpDCoxNlkmTHhrjFeruCee+O6G7J4hW14ESOrT+gS67nAzkwjuxUzKUHQYxE7tdw+9YDmMRI0sYmRzA2rS1OB3TJgdA6FVjXVOnP3AS61sMPI1OmItOYRkyfpzh7bkMQsaPTnNM0mE82MQMeoQ10YpEw0wcIacxHGyWMYMsYybLDZk9lHoPM/GEDI7oDPSyLUwjZG/MaiDyk3fCI6vxtMCUTtbGHQfyikxapdt95lyRTApNy+W0H8ZcEU+TRsgnTa1WGXNF10kAATN5/FJ48jhbWdEalZgezylbZhCJKSVipBByEisbKbKLTfXZhJzAxmRgckoKo5mEnDxlABEv42uZXISc2v23FvE4MU/kIeSczn/qffxNJ8gi5IYdPwa347aEhQiNS6cR55vETJ+XkDP23TVU7PYzAbMJqS929bU+fHgbUV2OkHOWnUwaeJERRfMTcnIX91LklJ4HCxFyQvcKOLKTs587PyGnmR0rwy0zrRYtQchJo05d2ViTlN1EOUKO33SnhyS2v94uYKoTcobTlTqcTJ3sNFiCkMab9bwLy+itY24n6iHk+P249WUkh37c2X1NhDQzrlqOqdYqXxYsTcgprQYcGmJyx9CyhDTgzFpbRuunSIgpS0hTY3/QijeS8aXwApYj5Lje+fOmiu2RXHwByxJyovppU7VmTrEQWpHw06ZKxv0yBlqJ8GaqH2Ik1EBLP2YFQmqqW/sDjMRelTXQqoS0xlEnTa8jsU01+dalcUKfcX1skJG4k4p8lQmprcpnvSFGchxV5quB0Ge8jq3a8yMmh6tcxf8eqoGQMgq/pl4nJCbH1VCog68mQiq+t9+5pBZITOxZX86/ic9QXYRUinz5mVeFxGR+2qi14XG1EtJ9h6RuVguP4FKYGBNvvNuoUqnyM1G1ElIZiqBeVoN5QUpKN1+sLqqg1IvH1U/oy6fsmwPbIjk4KRux7IHZb4LOVxOEN/GarO6v5mlhez4ofmW9/eCjjU/m916Vtep5L0mNEd4k8pIgq79fa3N3mi50d+5Zljd39cXyNDPX16EqCxJfT1JIVLOEdxkir0iaJvRkWVVluSdomqTwYiNG+aZ/XV2UECSvux4AAAAASUVORK5CYII=" alt="" srcset="" />
    </div>
}


export function ChatCard({picture,name,job,lastMessage}) {


    const [lastMessageCount,setLastMessageCount] = useState("");


    // const Default_user = ()=> {
    //     if (picture) {
    //         return {picture}
    //     }else {
    //         return user
    //     }
        
    // }
   
    
    return <div className="card " >
        <div className="card-row" >
            <div className="pictureFrame">
               {picture}
                <ActiveIcon />
            </div>
           
        </div>
        <div className="card-row">
            <h5><strong>{name}</strong></h5>
            <h6>{job}</h6>
            <h5><strong>{lastMessage}</strong></h5>
        </div>
        <div className="card-row">
            <p className="counter">
                {lastMessageCount}
               </p>
        </div>
    </div>
   

}
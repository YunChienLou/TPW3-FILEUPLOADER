package tirc.tpw3;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import tirc.tpw3.fileupload.Meter;

public class TestApi {
	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	class MyObj {
		int id;

		String main_number = "4444";

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMain_number() {
			return main_number;
		}

		public void setMain_number(String main_number) {
			this.main_number = main_number;
		}

		public List<String> getMeter_number() {
			return meter_number;
		}

		public void setMeter_number(List<String> meter_number) {
			this.meter_number = meter_number;
		}

		public String getTask() {
			return task;
		}

		public void setTask(String task) {
			this.task = task;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}
		
		

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}



		List<String> meter_number = new ArrayList<>();

		String task = "taskname1";

		String image = "data:image/jpeg;base64, /9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIR9oADAMBAAIRAxEAPwBdLVWu98nboM4q3PMhneRQBjBwScn9KqWCkT7h2z+NX54Y+ZCTkLyK6o/CeBWa9rd9irJGlyoQqpbsakGhsy74mAJPP+fzp0TrGFcusa4GM1et7hbknDY69O9Uoxe5nUq1YL3NjIfTHiZgwDcfw9qY9mpiKd27+9aly2ZUj4UZIHvxUMijaozyTScEXCvUaTZl/ZmO0g4BHUc1EbRhsIPTIArVONiqMjHTFSRxKAWOCBzU8iZt9ZlExBZyL8oyQGyfc1FJHIjESBs9ORXRMyW0M03kXEiouSlshaVsnHygYORnOe2M1Vm09bK0ggWaecKmRJcf6zaSSA2cHjOOeeK0eGtR9pfrYUMwvV5GiirSBAZdyIoGAfeprEjzhK4zxwD64NRzv8pA+bAp1gP3y+Z0HYEVit0bT1ptm5aR2zRTS3JG1VBz0rnbhxLcvJFH5a54UZ4q/dyo67WmIAOdo7/40qWlylu0otm8scknirk+ZWXQ5aKVJucnvok3oYyXU4IAcn0FPDTSHcVXPrtAzUUkxMoZVCkdx3pXYtHvLEsTgjNc3NbdnsezvaySuWjmPkBFJ/h3dKRSHAIJqlyzdaepKfd4/rUuvFOzLWDk4tpj5YwCWAx7VARxnNXPNV14xnuKhkjJY4x9MUThf3ojo1nH3Jon0xwlzkopJ4BOeK6mZpbKGOVWbYT2Pf6VzGjqG1CNWGRu9K7K8iMkAQ9VwfzzXbhot0210Pn82qxjiYxls9zMe4injMtxbQzDdtLtGM5+vFV3sNJn6QSwjPWOQn+ea0vII02SE45bd+AI/wAaht4Va0libaryyKiMSB83J/p2rT2Tk0mr3OWOIVOLlCTik7aN+XTYzH0K3lBa2vseiSp/Uf4VWl8O6guWjSOcDkmJwf54ret9OMX2gzZyo4JPGetNmspZrSb5jGRGXHBycVlLCxtdxsdcM2rJ2VRNabpP8rHKNDJbyGOaNo3H8LDBpMVGZHcgu7N2G45pQTXkVYe82j6+hUbglLckpjKeopd3GaA1ZQcoO6NZqNRWkRE9c9+uaSpWww9DUZByM12wqKfqcFSk6foOjlaKRXTGR61b1a5GseHrvTOIZ5gNrn7gIYHnHPPToaokEcd6M4Oe9dFHEVKFRTpvVanNUw1Ksk5rbqjhn8L69alZIrOWQ/eBtmEjAepCkkfiBUcXibW7aR917LI5G0/aAJSPpvBx+FegiTfw3WuP8dRN/a9rcMSzXFqrFj1OGZP5KK+ly3M3j5So1qaTSv3T17MivRVOUXdNPTazXX+th1t43nUxrc2MLoowxidkZ/ck7h+QrrdPuze6fFdGCSAyZKxyYzt4wQe4PrgdK5Hw14a1H7VBqt3YQrpsTBme+kEUZB6HnqO/Qg4wc9K7CW+0+W4laDVLW4G4ZbzgGYn2OCfqBXHnmX0vY/uKF5d49Pku/mh4PGpYjk9pot7u/wArvbv3JyaRsbeaSRHibEiMhIyAwIOPWkJ4r4l03F2Z9Gqqmrp3Ru2cflplvrVhhvgdcqWAxyeaYWSNHJ681nGfM+0SOGC8AdK+luo6HwShKo3IVvJLBZQS4xgHpU9rcx+b5exYV5OT0BrMu2wy8knjt2/zmqo8wZJDDjHOaxc7M71hlUhqzoX1KCS2SRlLvvKpgc5x/KoHnjMrPuAERw5AyPb61hZIAHIxzmjc21lycE8/Wpdd9TSOXRj8L/q50Eg8yMBGHTOBycev0/xp01zHZaXPfSKZIreIyMkfJfHb9evYc1lRXTyKUz8+zAOOW9v0qOO/ljeNjtbYpUBhkYPUEVrTrU4yUpq6OeWCqSTit0bWnyX11YaXcSRxBpV864ZVACrt3Kn1+ZR64U1Hdt5sgiTl3AX2AHvWYmozIqoSSok3sBxken0qR9SJcSR7hIOnpitK+Mp1tYpRWv4u/wDwCKeW16U3fUW8gNufLJXO3cSBxTLI75duRnBIz3qK6vmupPMZcHbtxninacnmXAG7bkfermUk5aHY6co0X7Tc3NMsI5JTPLE0giP3EAOevOK35rmCNGMn+rYfMrDHBqjpUsUBcySLGrYVd7YyeelP1hlFlN6kdu9ejFclK6R8pXbr4zkm3bQ5TVdN+xXq7GDW8vzRP2I9KqBk2SKsaHcByeq49Kn/ALTkfTDZSKrgOGjY9U+lU0JBzmvIryVrwPtcFTqW5a2ttPXsx4QA8HOO/rSnpSg5+tKUbHrXBzXep66jZaDOaVWJPJx3q1bWTXMbMs0EeDjEsgQn86qlCTtOBzjk1vTnKG+zOSrGnVuk9UX9LvYrLUkuJAGUEg49Mdq7Jpo7q2EsbBkbGCPxrzvDKQCMGtCw1SWxJCndETkp2PvXp0MQkrdGfN5llbqzVSOkl+R14B8og8gg/wA1qheqVNlgDIvU7/7D/wCNSrqln9ljZ50iEoJUyMAO2Rk8Z9qivg0sVo8Q3qt5FIWQbsqCckY69e1etQi+eEraNP8AU+daceaMu/8AkXYSWExkc52Z64OfrVeWQyW8TqmSXRCxG44ZgvUjPftU8YMTkPhTIuFDdTk+lVWzFZgsvCvExz7SKazouanGL66DlGD5pLpY49lwyqVwQOfrS7aQA7yc8k96lA/GvlcRUtI/TcLS9xIj24FAWp8c9KcqjPSuV17I7I4fmehWxzSOMjkVcaMYqJ4+DiiniotoKuEkkymecUnvSnGeOlBGBmvXbszxIq8dAHWpgbfAvDpqXuo2kRFnHI3ysS2encjLEevQc4NQ9O1Lkgg9MVrhsTLD1VUh/wAOuxniMPGvT5JHnWr6zqer3jy6jcyySbj8jEgJ7Be1Z1ei61olvraq+UgvlG0TnhZB2D47/wC119cjGOCvLK50+7ktbuJopozhlP6EHoQeoI4Ir7bCYynioc1N7dO3/AOSMVT/AHdrf10Os8Ezg2V/EzEsskToCeACGDf+yflXTO6pGzuG2opYhepAGSB71wfhK8+za0sJQMt0vk+4YkFSPxAH0Jru0kCSI5UMqkEqeh9q+az2gljYVZq6dr/LR/gdmHqSVKpCO/T5r/M6X55G8skZJPNQtB8zExqGx94ircEG5TIRls8U7yiRskbhsZINYWufNqoouyKCWQFx5kkiueMIB0/HvUzWsc2oBSw5jIAxxnsafJaujps4QDk81Fc5M6uQVYLxila3Q0U3N3UuhQlsizrH8uVJ3NntVQWzsxj2ru3YA/GtqNCzGTac4I56+tIiFZjJyT396zcEzpjiZRVjCe3aNpC24eXjkDFJKCxDYw/VlAx+NblxKkUf3QXbHWoEt5LiUIE69TjgVDprY6IYt/FJWMhQ0jrGoJZjinSRSQtsljZG9GFbqxw2VzGJIVLIRtcdgat3IW6UKIUYY6soOOe1R9VTja+pbzaSmny+6zkmHFX9Lx9o4ZQQh4P9Kj1GFLe6MajoAa24NMtxp4kCkPsznPt6U6NNp27BjMXB00/5h0SiVWSRElQ8lZFDAn6GqeqzrFEFAVWxtCjgADjp6U1b82ySLIp6fKRWVKzyhp5Tyx+WtqlWXJyJnLhsKnV55bfmQ9KkGPWoz0p4xivNnqj6Gnox4qVGGcHvxUcJiEgMwcp3CHmnzPC1x+4RljHTeefxxWM6HNFu5tDEuFRRUX69CYCgkKMniohJj347U+CSFrhUnVvKY4Yjqo9RXDDCylPlbsehVxkIUnNJu3Qh83bcpJjIXqD6VLdQxbRPbgpExIKMclSOvOKl1G0tYjvs7xZoycbSCGH+PT+VU2lb7OkQ42sTnPrj/CvZpWpL2cunzPn6v+0SWIp313umvwY+0vp7GXzIXKnuAeCPetm3eDUPnisYi6nczRoFkB9QRg1zvNKjlGyrFfpXVRxM6fwNr0Zx4nAwratLmOlkuGt2K7r2EnrmQsT+MgYj8KcdUEMWJnjaMkbkMJDNg9S27n8hWNa3E826I3D7VRmwznAwM8CqZcuwLc4GK3eYVYrmWvyX57nDDKKVSXJPQfnLEjIBOeamTpUQwKkU5r5yu+bU+zw65dCSlU81F5qjgZY+gpVlP9xq5ZUpW2OyNaHNuWetRsKb5yjqGH1FBkQ/xCueNKcXex0SqwkrXKB4OKmVcxg1Eww5+tTI37vGa92vJ8qaPnsNFczTGwQSXEvlxLufGQuetMdGjdkdCrKcEHgg1e0lgusWxbON4yBUuqW9/JdTtdQ5c3TpC64JdMKVGOvUtgn6dq7qVD2mHlVvqrad/Q8yri3TxioPZq9zKFQX+n2mrQeTeqcqCI51Hzx9+P7w/wBk++ME5qfggMjo6Ho6MGU/iKUUoVKuFqc0bqSOlxhWjvocPb2Vx4e8S6dLdIDHHcpIsi8pIqsCcH+h5Heu5ZCrFTzg4xTZoYrm2e2uI1lhcglG7EdCD1BHqPp0JFSTuZp5JNoBdy20dsnpXdmGYwxtOnpaSvft02MqVGdOcnLa252VjnyThFTOTtanXMnmIkIUK45JFIq/I3IAx36n8KLCAzXBZidoHUDBpq/wnyU+VN1X0IlMkG5WGRjJBFU5XQOXcqCex9K054vNv/IjU4/iJ5/z2qrrtlaw2yuwxKchcVMouzfY2o1oOpGL3kQhlKKFxk9cVPdKsMatkc4zxz+FZFkWjiZQp5xjIqS3eWWIK7MwxnJrNS0OudBqV76Ikjt5LrfMxAVB0HerFkXWQiLG4jHNPtRKLeXAAixgADkn1pLWFrhnCsBtGcn1ppbGdSd1JS2Re+xo6sZf3hPUVlXVzJpY8sjzInB8vPUH0PtWlDdOpMUwIbOAT3qtqdlHfRqVO2VOjf41VS/LeG5jhpKNVRr6xZQgu4ru5VmjyuRlDwa3p0RLR3iJaMqev8PHQ1xqiS2uP7siH/P4VpNrlyI2SNETeCGzzkH2rkp4yCTVTRnq4vKK05Rlh9Y+v9feZVzIXlIz8o6AUkhYxKrnJHQegp+GaQPuww4GKa0Ldj7VyvE07vU9qOCqKK93b7yE9KeB6VGRxUoHFRUdkbU1dj4xECfNDkEcbe3+eKQBd5w3HqwwfyGacvlFMOXDZ6qoP9RTAcE85/Chv3OjJS/et6r8vloPEhzjBPvSlwzqCpIz0Bx+tIsmR0NKGV2AK5HcZ2/ka5YR/ebHbUn+6fvX/r5E11bwxIkkFwsquOUPDIfQ+v1FVPwqzfQQQlGguVlRxkjGGQ+h9fqPeq4ikKhlRiuM5xXVKm3J2VvQ4KVeKppylfzas/ushu0ZppTByPyqQpIASUIA9aQhguSpA9SKEqkWXz0pqyZDzT0xn0obae+KbV/EiLckifHFDZwAO5xTEk7MaeTyDnvXK4SUjsU4uJKqgDjgU4UwNxQXHY1xyUmztjKKRIelIIw3Lc/Wp7d9P8k/ahdCUdPLKkH8xVYSqHI3YGcgMckD61c8POEOaL+4yp4ynVquEotW7qy+XcqyACQqO3rSqp2E84pZ+ZTj86dDJtjZfWu6UpeyjJavQ4YRiqsovRal1bSXTJw11DIj7dysGHy9cetUtV19tNtXu7qRJH2MIY3UHezbgDtGMjOck8cEdeKk+1TMI4Wlcw5HyFzt/LpXMfFG3EHiWEogSNrVNmDnIBIr38mw6xFa7dox1t3d+vkeHibRmqVRJylfXyXbs9TLtvGd7AyxtbWX2TduaCOBYwfcMoyD/gMgjiussbq31G0+1Wj74wQrj+KNjzhh+BwehwfQ48vq1Yahc6bcie1lMb4wfRh6Edx7V9Djsvp4xXeku/8An3/MqmvY/wAP7uh6aKD071Q0rVbbWIN0OI7lEzLAW546lP7y9/Uc54GTePTrXxeIwtTDVOSorP8ArY9GnVjUi7HaiMybYUxtY4yB0qaDZFBcq7kKVK7sc96hMuyRNkZ4XDe9La5uZGG37pBwe5z6e3WvSpu0lbc+IrRvTfN8P/BNC1ifaZmCpJIdxyM8fnWV4iglmaAIhbCnOB/n0rfHpkcVWugSR147e1bVIXhynn4XEOOJVSxyawtFEwYMD6kc1LaxuQoC5LYAyK051LXMYxyfbtTLr91NFhdvpXHyWPf+sOdlbVli5jMNkybduBVfSQd0hHTHPPerV5PusWjlz5oxtI/iFVtKB2ykA4yO3WtHbnVjig5fV5c29y1PCsyHK/N2NUzNJANki8YrQBJz1FUNQlAhKnknoKcu4qDbag1dGJqAVpJH289QRx0qiM7FdwQrEgH1rTXDOD3BzWbdO7Ts0vUk4z6V5uJpRkrtan1WX15wfInp/XQXeOCgB9Qc5/wpcs/AAXP8R6AUxWHIAP8Asnp+lOUvn5myvcA4rzJQjFrRfez3YzlKL1f3Ihkj2HG9W9Cvf+tKBnvSzbSQQTn0Pb8e/wClC1vNtq5hSVnZi4TYOXDD0AP9aRW2dAT9KU7NnBcNjpgEH/CkVwgwB+VFRXilZP0FSdpt3a9f6/UkWQEcg05WRnAZcqOoyF/ImkWQY5H6UqNGZRvUsvcBtp/AkYrmpx/ebW/r0OqtL9y9b/16r8x9/bwQMht7kTI4zjGGT2Pb/JrQ02FZLNM45rPv7eCB18i6WdGGemCvsa1NLGbOIjI4PTp1r1sMrVJK1j5zHzvhoS5m/Nqz+asif7Ism8MuQPU1FLpkBwFXaWwR35q7EMlhlgMY4NZ9/etGTbRsQwADMe3A6V01Zwpw557Hl4WFevVVKluUrrTPJhZ9xKqcke1Zow+ccVoyXFxNEYnnJU9eBz+lVhb7QSpryq2OotWgfUYTLcTDWtZ+hVIwcGnIw5B57A+lSyKuOetQEFTg04TVRGlSm6b8ix2oVgrqzKHUHJUnGaiR8YDdKswziEtiKKQMMHeuT+HpWMYcs7SNak+am3BXfa9hszRSSBo4/LXHKAkgH2J5oDoww3X3qNSAScZ9M80/cjjniorrmd2vu/yNMN7isn9/+f8Aw5BMoWTjpikUgA80sqhX4ORimiuuGtNXOOelR27i7trqeuKzPiptkuNKmAA/0fZ1+8Aev8xWj0NYnxCe5v8AVLaFYWfyUVU2KTkFEb+ZP619Lw7BurK3RHjY/XE0pdr/AJHC0orTg8O6rcuqR2b72OFViFJP0JFS3nhTXLAjztNmIP8AFEBIv5rkV9RZp2e4e3pXtzL7zLhmkt5klhkaORCGV0OCp9Qa9E0e/fWNKF3IiCdZGjkEa4BwFIbHbOTwOOOMdB57La3EBxLBJGfR1IrtPAQ3WGpg5yskO0Y9d4P8hXDm9BVMJKUlrHVP5q43NRamn/TPSzvDsN2SCasafEUErHAbGMk/d6nP5gVSL5lxtH3uKsW6CQzSBsBMDGeK+Zg7SueBXjem03bb8zTUz78CaJxnvwetMlYyhWPbI6Y6EimfZZVIYgY9R+NSSbR0YEEkjB9ea315Hc8z3faLld/Qz5AzX0eOnfmo70ObuME5xjpz3qQ4/tFfmGP/ANVR3b4vkJPAxkD61zvZnpwvzR9CfVRi2DEndnj2qrZziGByW5JxTL65W5I28IP1p1hArqzsMnJHJzSbvPQuFPkw9pkokuLj/VjapPXvTPsgEZYksTzk1fQKBgYAHaorjBhPT/gXpVOPcyjVfNyxVkc45AlJJPJP41nSYDlmfeSecVpmEO5G4HOcce5qhdRrDO6clwecngVxVdtT6TCS9+y3sMXOBkgYpw25zvH49KFJBGWK59PlBo+QZBB44rzal+l/uPcpcr0dvvuJIUKcAFs9QaRamlLmPbksoHTO7b0/KogDjjrSk3yq/wCIU0uZ2t8ncDt2HG4k9QQP50qyADAX9KHCgrt3bc/xgcfl1pVl46H8qK/vdL+gYb3d3b1X/DD1kU9v0pUMbSgMpK9wDtP4E8UBwR0/SlRovNXerMp67Tg/gTxn61zUl+82OrEP9y9b+m/y1X5i38EEEwW3uROhGchSMex/+tVrTrgJaKu4HBOVJ6VXvYYYpysE/nJjO7aV/Cqbx9cda9ClWVOo01b0PJrYV4jDx95vzas/mtDeN0CpYscDr2xWZPKJJmkjBYscncOKpAP0B4zUvzcAybfxxTxVb2keTQnAYL2E3Uu7/wBdyUGYclVNO80AfMpX9RTF7Ylyf96ngyjrhh+tePOMeqX4r/gH0UJSWzf4P/gjHcE9Pxpm1SuMcdqD16YpyntWyXLHQwb55e8VmXaen404TuITCeUzuAPY+tWRA8qSFYyyoNzEDoKqMhzkdK76VRte8rX/ABPNrU481otO34Eyu2AcZHrTtyN1xmoI3MZ46elTl42UkjJx0rlq07S0X3HZRq3hq/vIJVCtkZA7Ui4zzzSupQ4ZCP601T8wrutaFmefzXnddQ6HoKoeO7nU10iycXOyxkCqiI+MsAdwI6n/AOvWg1dHDoVh4h8MLb3cW9o94jIPKn1Br2sjxEaVe8tmmvQ8bOZxoqFWSuk/0PPNF8J3VjqunajPf2YjieK6ZA7l8AhtuNvX8ce9ausacdas4okvFtpoZS6PLu27WHzfdBOeF7djVyzsLiz06xt7tCsyQDcS+4kbmxz7DAHsKsiLfhUUsxOAFGST7UsxzytRx3u2bg2la+t9PxR3YTL1iKPtnPfrp0uedaq+paHqkliuqTSBArB0kYBgyhhwfYiuh8E6pf31ze2tzdSSxCETAOcncHVR+jmsLxZ5beI7h45Ekyqbij7hu2ANz9QenFWfA0jL4mjiUcSxSKfoFL/zUV9jXhOrgZOfWN9fS55kox9kpWV9Hc9gaNPNOFAPOPb1q1DCiWj7M7pHDHPsaYOVlfbkYx9KlhG4gDCgAZJ4AFfHRWp4NWb5d9v+HEgaVJURi3sfwqvdMfOyOADx7YFW5CxJQuTg8Gq05aOMNIoyxzvx39/1pv4bE0rOopd9DPSQrdL3J/Om3AM1yo3c8e3PFNjbNwu4deOmcU6ZitxnjisL6HqWtLTexHLzkt16Z6VoWHFuSc/eNQ3iBLKL7qu3J/nVaKVgAm/CZ5wOtP4WQ17WnoaLXcaDgb3zwB/jVeaOWaPfK+F6hRVq3jiiACKMnndnOaWdv3b/AEqmrrU54yUZ2ijG06B570BBuC5bGeSKpau4a/dfLCEYycctU9jO0V4HUkMufzxSa5PLPdCQpsjK8AdCe5rmq/wtNz2sMpLGK9rW/r1M1Co7DpmpAx/uD2qNS2OBg1MBITngD0rxa1utvvPqaHNsr/Jf5ifMwPABHTPemDkVIQdnzE7s9QePy/8Ar1GMBjySPpRCzStb8f1Cd03e+3l+gnQjIJ45yBUgkHAIP5VHkKTtBPepRIPQ/lSrrme1/T+mVhvdXxW9f6QodTzj9KdHJF5w3xl1PYHBH0PT86Aw69vpSxyQ+diWMuh4O0kEe47Z+orGgv3i0+/b8jbFP9w3e/po/lqh94kENwVt5/Oj6htpH4VWPIqW8SCKcrbzmaLqGKlT9Oar7hW06fvuyt6bHNQq3pRu29N2rP5qy/ICPU4oXZk/KT+FAOT0z7U5Q3PApt2WpSV3oOyhHKN+VKoT+Bz9P/rUfvO4XFKWX+JcH1Fczbtp+d/wOpJX1/K34kbdTQCAeSBTWUdyTn1NKqrkcheep6D8q6FFNWOaU2ndj3UoiSAjLZwUcEj646U0Rtg4PB7UpUbiAwI6BhkA04RkY2t+B5p1JqHurT11JowdT33rfqtGV3hZBnHFMBI9KtksOq5qu6fN8gJHpWtCs5+7IyxFGNP3ojpJS8CR/wAKk4Hpn09KiB5702lHWulRsrHLdXulYcx6V2XhR/8AiVEBSSJD0xxXGGuu8INmzmGMfOOfwrrwOlQ8XiJc2EfqjkLfT10truH7bJdSST7txBCxgZGBk5OcjJ4+6KsRtsZWzuwc4boat66HXWZzIiKS3AQYyPX61SU+mKwzGvVrYiVWo/e+7bY9bLVB4aK3TX5+hxfifRrXTDbz2jMsc7OpidtxUrtOQeDg7u/p1NV/Ck5t/FGnsOry+V/32Cv/ALNW540jzpdpIE3bJ2VnxwmVGBnvu2n6bPeuU0y7+w6tZ3Y6wTpJ/wB8sD/Sv0XLMRLF5dCVR3lJNP72jza9Pl56a6XR78ikoxJwvetK3jRSCvp61Rjf/RipXktnOK0VwkeenQZr5Kkrs+Pxk3Zoa0KnJ3GlMY8zkZBUDB9s/wCNPZl3Y4pEQDdnPzE55PTJxW0UtThlOVlc5hrZzdyNEu7axO0n+VUpdSjjvGWWJwMgN6r+HfiugsAWuZW559axLzR5L6/uGgkXzMklW4z9K86pGSjeB9Xhq1KVRwruyS3Ld9dQ3NpE8MismcdcY9jWe9xbLbgmXEozlBzWVLBJBIY5o2Rx1DCm5XPU/hXJPEybtbU9ejllOME1O66G5p2qfOYm6Z+UE4zWvOfMiJXB+XjmuM6DkA45wc1oW188UQRgdrAgkNn/APVW1Ku2rSOXGZdFSVSl+hLZoWutoOeD71Fq0ZWZGLggrgDPSprMlbjcO4PSotWKGdMZ3heR+Jx/Wpq/wmaYZv60vQopv9vyqQIc5LH6ZqNV5JZ8D3NPCRgAn8DXjVHvb8F+p9TTVrX/ABf6Dtiggli3sTwajYZzxwelSB0ThWIPoM1G6bW24KgDoadJvRu/zRFZK7St8n+gofB5BOOAepqQSqf4T+VMEmCflJ9+uaeJFPUfpWNZXbfL+P8Aw50Yd8sUlK3y/wCGHBk9P0pYngEw82Msh4JXIKj1HbP1BpAy+lLDJB56+bGWjJAYjIKj1GP6g1OHX7xafft8x4x/uH19NH8tVqNu0gjuHW3kMsXVWKkH8RUEcTzMQi5xU1wkaTyLC5eIH5WIwSPepNMf/SWTjDjsK9GhFSqNP8NjycTOVLDKUW27Lff57a99CrsZSVPykdRTgF7ycfWpLs5u5N45BwB7dqYpA/gY1jX92TSOrDPnpxlK2vqxwAJwsvP1zTv3iqd2G/nTSYyPmUge4zSgALlHz+Oa4pef4r9T0Y76fg/0IiaBtKtksG/hAXIJ9znj9aUrxmg7NibQ4Yfeyc7uewxxXZTs9Tz611Za69UKqqRhiPeniMr0YkelIBG4xnPanbCPutn61yTnd2vbyZ3U6dle1/NCb2Xkrx6ikCsyPKCp28sp4P1A7ilLOqHIODxkU2RfLiVlcFZOqnqvsf8AH/8AVWuHgmm7L7zDFVGnGKbXy/D+vx2KzAZzxTc09vu1HXpU9UeZV0egpIIrqfCDZS5jOcEhs5xXK10nhKZVupozjcyZUdzXXhdKqseRnS58FO6KXiRI01qXYHyQC2719vbp+tZqkAdf1rU8Q3C3l4tzG6tERsX1GOv6msoZHTr9ayxsHGpKMu515RO+GpvyRkeLkz4dMgdgFuYxjPBJV8ZHrgHB+vqK4HPNei+I1Z/Dl4BGsmNjEt/AAw+Ye/OPozV5zivseH5OWAgl0bX43/UmurV5+v6I+kEBESAY5f8ApV+UHYoX5iXTpzxuFYofHJyM+vpWisAWNHjcncM5968OlOzvY+LxVHa7t8i6VIznv3oRslhnIBxx24HFVF84yf6wgfWpmuUiVsggrmtYyVmzhnSldRWpRseHmIyD1qlCrnUZGU4IYnNWrSQLvzwRjiq1mxN7Ic5xk9OlcvY9mKadR+RFrUkd2qFo8OqnII6Guakj2MSpxg5znp6V0uplfOBz/DnH+NYEwYFgVJAzj3rnrK7uz18ufJTUVsV+xKoxXpubp/8AWoQknChQwPDbuf50feODudugUdKTGG5C/TPT9a5XZansxbas/wCvxNW1mCkSAtnG3B9ap3bBpdzcsfyxmkgk8sOp4DDg9QD/AJ/lU96GjjjVkGG+YEjkVrOV6bZx0ocmIS7+ZSVV5JJPrUgZFAwufpUa7F9T9KlDknCx/rXkVde/32Po6Oj6fddi71HO0/lUbHcy/LgdwRUwZieU/WmMCxxjAPQkVjSajrb8TasnLRP8LfiCybeNhx2Ip4kU9j+RqVIwoGKdsBNcdSvTbbsd1OhUUUrkO9ccgflUls9t5+24QmJ+GYZBT3GKcEHoKrzRlHZskZ6bRmtcLWj7TTfz2ZhjaEpUbPby0a80xkoVZHVcldxCkjqPWp7CEG8Dhvlj5J6Z7Cq+8Ben5U6C5MHmJsDLJwRnFerhpJTvJWPGx0JOlam7tq39eYw53nBDEk/Me/vUg8zA4X8qjCFh1xTwn/TQ/nXJWnFt/wDDnfQhJJb/AJDiXHVAfoaQlSOhU+9LtkHR8+x5oYtsIdR+Fc6tdW/A6nezvf5/5oizjHAOD0Penbl8xm2BVJ+6CSB/WkDlMkBSSpHzKD/PvTo2CLkrx6jmuqUrU7LW5xQjzVbt2t93zQ4CKTnj60uwj7rcUuI35GM+1HltkbW/OuJz6Xt6noKHW1/NDW4ZVlU7TyQrYJHtUc6+VIYll3qDlTgjI+hqRBHI5WXPQ4ZCMg/jwRVU5PWvQoxXKlp+p5daTdRvX9H/AMH+n0YnUGk5xjPU0dKcSNnT6V3U1ucFZ7DKfHI8MgdchgeKZ0NSq0McM8028JDGZCUAJwOvHetqMJTkox3exhXlGMW5bDVjtoLRIIFcASMwVukYbkqPbO4+2eppBkEggin/ACvHFLE6SwyrujkXlWX1H5cg8ggg4pgODz+dPFupOcnV+Lr3/wCHFhOWNlF6FfVRG+g6ksjMqGDJYdiGUr+bBR+Oe1eZ16q0cs0FxDEFMssEsSKT95mQqB+Zry+WCWFissbofRlIr6vhl82ElFa2k/yRGJ0rtd0n+n6H0AkfmOFyM571roVjRYmGSAORWVEjvMgXBJ9a1htRgHycL/jXjUtLs+Mxru0vwFBQ/cHzdgSR/nrVG4k3DJAHAyO3Sr6iMHMY+YdBmqF0p3OOOCTVzfuGGGt7Xr8yrBkqeRgHAqvbyCGZiq7nPRRVuEbo84xycZqlGpPmMGI2856VyvoexCz5kyC7dncuXGSfSqmqWwiWB12gOmDxVyUMHXORVjVbbzNFibAJjwahxumdUKqpzpro3Y5g8ZXcUjPYDk0mMAHaQp6E96e64OAAzeuOFFMJDY+Ys3cn/PNcVRaHvUHr/X9fePU8DCZYdCDz+VXLwSSWqTeZuDHOBxxVAMo64YVaSd0tjC/8J3qrZBxRSd48rJxMGpqotbP+urIYtpOBg4qcZz149KhUZ64/CnqSvBH4149dJyfKz6HDtqK5lYlLBeT+lPCMp+dCCQGAPoagI35GccVO0ryyGRzyRgc5wK53CCpSv8WljoU6rrx5V7mt/wBBcZ7mnUwOKXeK4XGXY9CMo9xwznrxTJV3ITjLAcUu8UySQYx27j1FXShJ1FYzrThGm29Sp1Hr9aQitjVJbSeIMjBpgRyBj8z3rJwD16V7tWKpzsndeR85hasq9JTlFxfmA8vucn25pyiH0/SpFC8ccU4YORgYFcU6u+/3npU6NrbfcMCoT8jYPsaH3Kh7090UryBUaMdwUqfeojLm95a27mko8vuvS/b/ACBIC2Cc4NWggHQUoxjjpRjnrXFVryqPU7aVCFNaIYYlPb8qjaJkRnDcLVg1HKoeJhkjAzgUUqsrpN6BVpR5W0tSozRm34C+YD94HHHpj+tQkjNIQV4PBppxX0cY33dz5iTUdlYXqacB8gx744pFAJ5OAOpp6gmM5/8Ar1vT3aOaveyZEeD7ip3RX07URwT9inxx1PltipoIrRkLXBlUknDJjH5Y4qdItPKSp9sKiSNk+dDj5lx1H1rqwc4xqxndWTX4M4sY5cji4u9uxy3g9JF8NXMjFnje7CoueIyFyx9sgr/3z7Vrk4/wqpoekS6LZX1vJf2syTNG6eUX6rkEYZR2bOf9kVbCMT0rrzqtTli5TjJNO2qt2KwdOU1Kye/Z+RY08f6bCTlgHXIAyevYevp71yB+IOv4MU8sFwmfuzwK39K6jLofc1T1DQdO1q4F1cPJbzjJmaJQfO/wb37/AF5rryPG4ahzRrLR6p2vt/mYYzDqc+arHmtp5o9BWMLOq7u2a01eJlwynNZt3NArtcbwYY1GdnclsAfqKlYGORwcgA8cVzpOCv0/yPlakVVtd2di+FUMTGfm9DUV1GvkyMcdCeaS2DhizABT7Ut8cWrc84q27xOSKcayV+xWtI91sSSMgn+VYpmEW/ccgsM/nV93aGw8z7QU64XrniscLvdQBnp0rlm9kj3cLTu5yb0v+RaurmOeVDEDsCAHPGKdLdyS2bQNggjGfSqoCnoQB70punBKEZQLkDpz9ajmZ0qktElsZDqVQqSQB19zUa7gOflB7etXpYdzZUj6GqrQOjEsQSeetctSLtoj2MPUi2ruw0g+wHuKNuWyBingMOSpxS7wSev5V5rdWO0T2V7Ga+L8Ry08CohIv94VKpBPWuGrGS3PSpSi9mLgA0Z4oNM3jpkZrJRbNXJRHZopM0ZquUnmFBpRTBmnUpRHGQjn5DUKjcehx61JIfk7/hUcZxk100lamzlrO9REw2gY4p4xj3qDkmpVPWsKlOx0Uql3sKTzj1peMVHnLZp3aocbWRane7HhyKeHU1DmjNZyopmkazRZ4NINpOCQPrUGTjFCsVlSQYJU55HWpp4dOVpSsu5VXEyjFuEbvt3Kch3SMR3NMxmtK6aK6Ib7OkT92RvvfhiqggKyLk5TPJr2/b0o+7GV7HgKhWmlOcLN7+X3E4tc26pnDZyarbSFKqBkH+tae7PTpWc3+skyOme3ua5sqr1Kk5qb8zoznD06VOEoLyJrdd1tt9CaDEPSnWf+oJz/ABU6SaJOByfauSpKosROMF1PQpRpvDQnN9EQ+UoHNRhMt+NaOl6bcavO6RgqqIXzjjipVsPJ5k+T69T+FTUx0aLcJO8iaeEVdpx0RQ8gyjDcfzqFreSGUBhgN0PrXU6Bpg1jUvssR8tVXc0jDJxntXoX/CJ6QdOksntg6yDDSNy+fXNVgsZiXP3Y+6t/+B5mGZ0MLGPK37/f/M8z8QxJa6W8cbk5uYlz7810axBoUZvmJUZGMmuZ18bbC1HLFr6Mk49A1dSrusYLRkjaOF5r9I5U8LT06v8AQ/HMVOUWtdf+AiOCUyLI21lAbaAw5HAqPUTi1OemO4pYiyrIWVlJcn5u/A5qvdyl7YjPIrkrtJtIMLBucZeZWNssunF2XLgEj2rPgPkxuu1SWABJHQVde92WawofXJ6nHpVHeSMkjpXHJrSx7lGM7SUtrkZ74AA6GoJF/eVYONvAOT1qCT5ST14rJnbB6iqi/h6UySIbR0B+lSq/JHX1OfamOexPXj60FJu5XZQEOOm3k0zYQNpGalYqgYZ6jkCo2PY/ezUG8WyvIBz646Y5qu2M8VYkcbTjPBxmoHYk9fyrOR107ibjjqaF++D70Khb6etKMBgPQ1hJxaaR2QUk03sWc+9KenWmUpORmvK5T2eYcOKcKiBpwPX6VMolQmJKeKYnTrSSnpQOBXRGNqaOaUr1GPHWn7sLnNRKeTS56ConC71NITstCReBTjyKYO9L2rFrU3jLSwuaPYU3NHGaOUXMPozzSZozk1HKXzD+tLjjrTaUnArJpmya3JIjhf6VUcHzJcYx15qxuqLPLkc+tduWQarSfdHnZxNPDxS6P9CNQTbsQcAN0p1pY3N9MscMbuzdABmiEKSwI75wa9b8E2drFpEUyRr5sg+Z8cnmpxOJnSq+yhvJ7vp/mZwpweHjVlsla33mxoGnrp+iWluYQkiRAOO+7v8ArViaxtGfzTbx+ZjAbaM1bqCdgF61nUpU40rSSdu5yqcpTcl1KcdnDZzRuiKCe4GOvWtIHIqpct/o8ZB7ipI5h5YNYYZ06E5U46LRjnzTSkzzG0kWWXy3VZELZG4ZwfWrMtxeQsf9HZs8LtYEfyrOilWLUMqOpJxWuZ2I3E4FffUK3KrSVz82xtC81JLdEYkZIHkcFXYFsMMEelZUtzI6bCQMnnHFWLq7WWTy0PynriqWxTjBIOe1YVqnPK6OzCUFTjeS1IWJODyRn8KQEgBvoetWwgVeAMfSm7QcYrGx3KaKRcYyDxj9ahkfLc8ZqadfnOB271WcAgEgcevaoZ000tx3mjPI/WmyOrAg5/oaFHH9aikHYHnHepNYpXEL5QjJ6c0nlkjO4Y/+tTMgQ8HIx70KcHueec1JtbsRSoR15HtUIA/D2qWQ7pOecAUwpzkVy1aqUuU9PD0W4qb1FDccUmwZzRtx2pQK5nZfCztSbtzIdQTRt96NvvWXumtpCg0oNMKsMYGfoKljTJOSePYipmko83Qqm258ltSJlLtgU7ymxVoKoXpSbB2Nc/1t7LY6vqS3b1Ku0rnIIoB96t7M1BJEFOQKuniYzdnuZ1MLKCuthoPFLTV5OBSnI61bjrYhS0uBopuaM4p8pPNqPzTlPNMFLkDjNZuN9DRStqyQU2V8YAPNNEynjOKikfc5wciilRbn7yHVrxUPde4/eRT4iCGzkc1WD1ZtwGRs9M9Pyr0sPT5ZnkY2pzUt+o0HErA+1ereCpsaHb4Pc/zNeUSt5b5Knnjpiuw0HxTZ6VoyJMzNICcIvWvGzmnVVSFSnFvXp6HZg5KeF5L/ANXPUPOwOfSsnV9dsdNQm5uEVscJnJP4V5zqnjvUr1Wjtv8ARoz/AHfvH8a5eaSWZy8rs7NzuY9aqODxWIjafuL8f8v62MnOjTeru/L/ADO41X4iySxiGxgCqP435NU9P8falb7xcItxkggcDH5VySjHBHJGBnilXEbrnnIrtWUYa3vJt976mTx09VFK3a39P8TpITtmRmPQ9KuzXXmDZHwuMH3qiilCR7elOWQF2GPxxXvp2Vj5GdNSlzdh23b34x69KVVAOcgn+tMWVWJ5FHmhhwPwo0HZjyQVGCcevTtRyRwx465phkUggHJ69KFdCgwRu4ouFilKzK5ViPYjioZOQf6VoyxpMmw9SOCR+tZ0i+TIUIJz90+orOSsddKSlp1BVZt2wEkCkaM7funr61Kgwx5ORjpUF9PKCQAAuMEj61L0VzSN5SsiESrggEfQGgcLheBnr+FVEG51HqQOa0FXAHXIPpWcG5HXWgqexUbG/jHSlGe9Ew2y/hRn5a8/Er32exg2vZIXigCmg0ufeuZxZ1qSFxQetJmjNJJjckOwTyCRUi9OTmos5HWlBI78VnOF1Y1hNJ3LGaX+VRB+KdmuN02jtVRMeKZIflIA5NG6m7sjNVCDUrkzmnGwxFwOetONGaaTxXRdt3ZzWSVkNIFNxzTqcCK1UmjFxTFRD34oaNQpwO3enK3vTs1zupNSudMacHGxQ7UZFXSin+EflUMsS8EDA74r0KWJjOSi1Y86rhJ04uSdyv3q7Z52tTRBnt8vv3P1qykWxRznj1r04Qs7nh16ylHlKc6/MpAwKWKHj5vyIp8+5ZPocD8qAG7cY6U7ak8z5EI0W3lTx356011I7ewzUmCCRk8jg0EDaMjI9MUWEpMg8lyOR+JpFid2AI9qnAHPXA5x0xT7ZJZrkRW+GbB5PQ1nUnCnFzm7JGtNVKkuSCu2bBcjKAZxUse3Z0BxUscSPuypJyaclugGec4xXckz5+VSOxVnwBwO1VduW5z9a0ZLMyLlCMgcD1FUgvJyMHPIz3qZI1pTTWhHz7kc9ulJk4BHQetS7N24E85P8hUsVqzYxgknnmpszRzSWpEMlQSDkjkVHNCsw2YyT0+tWXQxnHH3c9ajBy6r1Ge1NroKMuqKQLqzJLw6nHpn8KSVPMUhh8pOMdKn1D5r4lDg4HTuMd6iWbzF7AjrjNQ+x0RbaU0ZzQtE8ee7CrqrgjgetP25G8YyORQMbecAnpmojFR2NqlZztcoTj98Oe3Wk6DmnXP+uX/dHaoN3PrXDWg5T0PZwtRRopsk/wAKUVECc57U4GsZU2jpjUTJO9J9KZml3dan2bL9oh/alzUYY0u7modNlxqIkLeho3UzdSZPFT7Ir2pMGpN2ajDZoDZpeysV7W6JA2KTNNz70Zpcge0F4oGDTSaM1XKSpakq4p2ajHXrT6wnHU6IS0FNIaM0hOelTFWKk7j4ZNrbG5HY/wBKsEggHGABVNSFlXIz8wGKuEjAwPbP0r3cJNzp69D5XMaUadb3VvqVJ1O7ceOeo+lMLMEwE4PcHHapLsYQkZwD39at6Ykcs7mUZKcDPas8biVhaTqtXsbYDCvF1I007f8AAK0NtdXI/dQEr6kUsthedTCwxnmusiZVXCgBfSs3W9Q8uHyI2w7/AHj6Cvm6Gd4zE11SpRWp9BUynB0KbnUvp1v/AMA54A7SScHA49au6HuGrRY6BTmqJ3MpwG6D866DSbb7ND5jD94/JPp7V6udYmNHCuD3lp/wTzcnw0quI51tH+kj/9k=";
		
		String error;
	}

	@Test
	void test() {

		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);

		RestTemplate restTemplate = new RestTemplate();
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("ABS_1-1");

		Meter testMeter = new Meter("MMMM03", list, "task 003", "data:image/jpeg;base64, /9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIR9oADAMBAAIRAxEAPwBdLVWu98nboM4q3PMhneRQBjBwScn9KqWCkT7h2z+NX54Y+ZCTkLyK6o/CeBWa9rd9irJGlyoQqpbsakGhsy74mAJPP+fzp0TrGFcusa4GM1et7hbknDY69O9Uoxe5nUq1YL3NjIfTHiZgwDcfw9qY9mpiKd27+9aly2ZUj4UZIHvxUMijaozyTScEXCvUaTZl/ZmO0g4BHUc1EbRhsIPTIArVONiqMjHTFSRxKAWOCBzU8iZt9ZlExBZyL8oyQGyfc1FJHIjESBs9ORXRMyW0M03kXEiouSlshaVsnHygYORnOe2M1Vm09bK0ggWaecKmRJcf6zaSSA2cHjOOeeK0eGtR9pfrYUMwvV5GiirSBAZdyIoGAfeprEjzhK4zxwD64NRzv8pA+bAp1gP3y+Z0HYEVit0bT1ptm5aR2zRTS3JG1VBz0rnbhxLcvJFH5a54UZ4q/dyo67WmIAOdo7/40qWlylu0otm8scknirk+ZWXQ5aKVJucnvok3oYyXU4IAcn0FPDTSHcVXPrtAzUUkxMoZVCkdx3pXYtHvLEsTgjNc3NbdnsezvaySuWjmPkBFJ/h3dKRSHAIJqlyzdaepKfd4/rUuvFOzLWDk4tpj5YwCWAx7VARxnNXPNV14xnuKhkjJY4x9MUThf3ojo1nH3Jon0xwlzkopJ4BOeK6mZpbKGOVWbYT2Pf6VzGjqG1CNWGRu9K7K8iMkAQ9VwfzzXbhot0210Pn82qxjiYxls9zMe4injMtxbQzDdtLtGM5+vFV3sNJn6QSwjPWOQn+ea0vII02SE45bd+AI/wAaht4Va0libaryyKiMSB83J/p2rT2Tk0mr3OWOIVOLlCTik7aN+XTYzH0K3lBa2vseiSp/Uf4VWl8O6guWjSOcDkmJwf54ret9OMX2gzZyo4JPGetNmspZrSb5jGRGXHBycVlLCxtdxsdcM2rJ2VRNabpP8rHKNDJbyGOaNo3H8LDBpMVGZHcgu7N2G45pQTXkVYe82j6+hUbglLckpjKeopd3GaA1ZQcoO6NZqNRWkRE9c9+uaSpWww9DUZByM12wqKfqcFSk6foOjlaKRXTGR61b1a5GseHrvTOIZ5gNrn7gIYHnHPPToaokEcd6M4Oe9dFHEVKFRTpvVanNUw1Ksk5rbqjhn8L69alZIrOWQ/eBtmEjAepCkkfiBUcXibW7aR917LI5G0/aAJSPpvBx+FegiTfw3WuP8dRN/a9rcMSzXFqrFj1OGZP5KK+ly3M3j5So1qaTSv3T17MivRVOUXdNPTazXX+th1t43nUxrc2MLoowxidkZ/ck7h+QrrdPuze6fFdGCSAyZKxyYzt4wQe4PrgdK5Hw14a1H7VBqt3YQrpsTBme+kEUZB6HnqO/Qg4wc9K7CW+0+W4laDVLW4G4ZbzgGYn2OCfqBXHnmX0vY/uKF5d49Pku/mh4PGpYjk9pot7u/wArvbv3JyaRsbeaSRHibEiMhIyAwIOPWkJ4r4l03F2Z9Gqqmrp3Ru2cflplvrVhhvgdcqWAxyeaYWSNHJ681nGfM+0SOGC8AdK+luo6HwShKo3IVvJLBZQS4xgHpU9rcx+b5exYV5OT0BrMu2wy8knjt2/zmqo8wZJDDjHOaxc7M71hlUhqzoX1KCS2SRlLvvKpgc5x/KoHnjMrPuAERw5AyPb61hZIAHIxzmjc21lycE8/Wpdd9TSOXRj8L/q50Eg8yMBGHTOBycev0/xp01zHZaXPfSKZIreIyMkfJfHb9evYc1lRXTyKUz8+zAOOW9v0qOO/ljeNjtbYpUBhkYPUEVrTrU4yUpq6OeWCqSTit0bWnyX11YaXcSRxBpV864ZVACrt3Kn1+ZR64U1Hdt5sgiTl3AX2AHvWYmozIqoSSok3sBxken0qR9SJcSR7hIOnpitK+Mp1tYpRWv4u/wDwCKeW16U3fUW8gNufLJXO3cSBxTLI75duRnBIz3qK6vmupPMZcHbtxninacnmXAG7bkfermUk5aHY6co0X7Tc3NMsI5JTPLE0giP3EAOevOK35rmCNGMn+rYfMrDHBqjpUsUBcySLGrYVd7YyeelP1hlFlN6kdu9ejFclK6R8pXbr4zkm3bQ5TVdN+xXq7GDW8vzRP2I9KqBk2SKsaHcByeq49Kn/ALTkfTDZSKrgOGjY9U+lU0JBzmvIryVrwPtcFTqW5a2ttPXsx4QA8HOO/rSnpSg5+tKUbHrXBzXep66jZaDOaVWJPJx3q1bWTXMbMs0EeDjEsgQn86qlCTtOBzjk1vTnKG+zOSrGnVuk9UX9LvYrLUkuJAGUEg49Mdq7Jpo7q2EsbBkbGCPxrzvDKQCMGtCw1SWxJCndETkp2PvXp0MQkrdGfN5llbqzVSOkl+R14B8og8gg/wA1qheqVNlgDIvU7/7D/wCNSrqln9ljZ50iEoJUyMAO2Rk8Z9qivg0sVo8Q3qt5FIWQbsqCckY69e1etQi+eEraNP8AU+daceaMu/8AkXYSWExkc52Z64OfrVeWQyW8TqmSXRCxG44ZgvUjPftU8YMTkPhTIuFDdTk+lVWzFZgsvCvExz7SKazouanGL66DlGD5pLpY49lwyqVwQOfrS7aQA7yc8k96lA/GvlcRUtI/TcLS9xIj24FAWp8c9KcqjPSuV17I7I4fmehWxzSOMjkVcaMYqJ4+DiiniotoKuEkkymecUnvSnGeOlBGBmvXbszxIq8dAHWpgbfAvDpqXuo2kRFnHI3ysS2encjLEevQc4NQ9O1Lkgg9MVrhsTLD1VUh/wAOuxniMPGvT5JHnWr6zqer3jy6jcyySbj8jEgJ7Be1Z1ei61olvraq+UgvlG0TnhZB2D47/wC119cjGOCvLK50+7ktbuJopozhlP6EHoQeoI4Ir7bCYynioc1N7dO3/AOSMVT/AHdrf10Os8Ezg2V/EzEsskToCeACGDf+yflXTO6pGzuG2opYhepAGSB71wfhK8+za0sJQMt0vk+4YkFSPxAH0Jru0kCSI5UMqkEqeh9q+az2gljYVZq6dr/LR/gdmHqSVKpCO/T5r/M6X55G8skZJPNQtB8zExqGx94ircEG5TIRls8U7yiRskbhsZINYWufNqoouyKCWQFx5kkiueMIB0/HvUzWsc2oBSw5jIAxxnsafJaujps4QDk81Fc5M6uQVYLxila3Q0U3N3UuhQlsizrH8uVJ3NntVQWzsxj2ru3YA/GtqNCzGTac4I56+tIiFZjJyT396zcEzpjiZRVjCe3aNpC24eXjkDFJKCxDYw/VlAx+NblxKkUf3QXbHWoEt5LiUIE69TjgVDprY6IYt/FJWMhQ0jrGoJZjinSRSQtsljZG9GFbqxw2VzGJIVLIRtcdgat3IW6UKIUYY6soOOe1R9VTja+pbzaSmny+6zkmHFX9Lx9o4ZQQh4P9Kj1GFLe6MajoAa24NMtxp4kCkPsznPt6U6NNp27BjMXB00/5h0SiVWSRElQ8lZFDAn6GqeqzrFEFAVWxtCjgADjp6U1b82ySLIp6fKRWVKzyhp5Tyx+WtqlWXJyJnLhsKnV55bfmQ9KkGPWoz0p4xivNnqj6Gnox4qVGGcHvxUcJiEgMwcp3CHmnzPC1x+4RljHTeefxxWM6HNFu5tDEuFRRUX69CYCgkKMniohJj347U+CSFrhUnVvKY4Yjqo9RXDDCylPlbsehVxkIUnNJu3Qh83bcpJjIXqD6VLdQxbRPbgpExIKMclSOvOKl1G0tYjvs7xZoycbSCGH+PT+VU2lb7OkQ42sTnPrj/CvZpWpL2cunzPn6v+0SWIp313umvwY+0vp7GXzIXKnuAeCPetm3eDUPnisYi6nczRoFkB9QRg1zvNKjlGyrFfpXVRxM6fwNr0Zx4nAwratLmOlkuGt2K7r2EnrmQsT+MgYj8KcdUEMWJnjaMkbkMJDNg9S27n8hWNa3E826I3D7VRmwznAwM8CqZcuwLc4GK3eYVYrmWvyX57nDDKKVSXJPQfnLEjIBOeamTpUQwKkU5r5yu+bU+zw65dCSlU81F5qjgZY+gpVlP9xq5ZUpW2OyNaHNuWetRsKb5yjqGH1FBkQ/xCueNKcXex0SqwkrXKB4OKmVcxg1Eww5+tTI37vGa92vJ8qaPnsNFczTGwQSXEvlxLufGQuetMdGjdkdCrKcEHgg1e0lgusWxbON4yBUuqW9/JdTtdQ5c3TpC64JdMKVGOvUtgn6dq7qVD2mHlVvqrad/Q8yri3TxioPZq9zKFQX+n2mrQeTeqcqCI51Hzx9+P7w/wBk++ME5qfggMjo6Ho6MGU/iKUUoVKuFqc0bqSOlxhWjvocPb2Vx4e8S6dLdIDHHcpIsi8pIqsCcH+h5Heu5ZCrFTzg4xTZoYrm2e2uI1lhcglG7EdCD1BHqPp0JFSTuZp5JNoBdy20dsnpXdmGYwxtOnpaSvft02MqVGdOcnLa252VjnyThFTOTtanXMnmIkIUK45JFIq/I3IAx36n8KLCAzXBZidoHUDBpq/wnyU+VN1X0IlMkG5WGRjJBFU5XQOXcqCex9K054vNv/IjU4/iJ5/z2qrrtlaw2yuwxKchcVMouzfY2o1oOpGL3kQhlKKFxk9cVPdKsMatkc4zxz+FZFkWjiZQp5xjIqS3eWWIK7MwxnJrNS0OudBqV76Ikjt5LrfMxAVB0HerFkXWQiLG4jHNPtRKLeXAAixgADkn1pLWFrhnCsBtGcn1ppbGdSd1JS2Re+xo6sZf3hPUVlXVzJpY8sjzInB8vPUH0PtWlDdOpMUwIbOAT3qtqdlHfRqVO2VOjf41VS/LeG5jhpKNVRr6xZQgu4ru5VmjyuRlDwa3p0RLR3iJaMqev8PHQ1xqiS2uP7siH/P4VpNrlyI2SNETeCGzzkH2rkp4yCTVTRnq4vKK05Rlh9Y+v9feZVzIXlIz8o6AUkhYxKrnJHQegp+GaQPuww4GKa0Ldj7VyvE07vU9qOCqKK93b7yE9KeB6VGRxUoHFRUdkbU1dj4xECfNDkEcbe3+eKQBd5w3HqwwfyGacvlFMOXDZ6qoP9RTAcE85/Chv3OjJS/et6r8vloPEhzjBPvSlwzqCpIz0Bx+tIsmR0NKGV2AK5HcZ2/ka5YR/ebHbUn+6fvX/r5E11bwxIkkFwsquOUPDIfQ+v1FVPwqzfQQQlGguVlRxkjGGQ+h9fqPeq4ikKhlRiuM5xXVKm3J2VvQ4KVeKppylfzas/ushu0ZppTByPyqQpIASUIA9aQhguSpA9SKEqkWXz0pqyZDzT0xn0obae+KbV/EiLckifHFDZwAO5xTEk7MaeTyDnvXK4SUjsU4uJKqgDjgU4UwNxQXHY1xyUmztjKKRIelIIw3Lc/Wp7d9P8k/ahdCUdPLKkH8xVYSqHI3YGcgMckD61c8POEOaL+4yp4ynVquEotW7qy+XcqyACQqO3rSqp2E84pZ+ZTj86dDJtjZfWu6UpeyjJavQ4YRiqsovRal1bSXTJw11DIj7dysGHy9cetUtV19tNtXu7qRJH2MIY3UHezbgDtGMjOck8cEdeKk+1TMI4Wlcw5HyFzt/LpXMfFG3EHiWEogSNrVNmDnIBIr38mw6xFa7dox1t3d+vkeHibRmqVRJylfXyXbs9TLtvGd7AyxtbWX2TduaCOBYwfcMoyD/gMgjiussbq31G0+1Wj74wQrj+KNjzhh+BwehwfQ48vq1Yahc6bcie1lMb4wfRh6Edx7V9Djsvp4xXeku/8An3/MqmvY/wAP7uh6aKD071Q0rVbbWIN0OI7lEzLAW546lP7y9/Uc54GTePTrXxeIwtTDVOSorP8ArY9GnVjUi7HaiMybYUxtY4yB0qaDZFBcq7kKVK7sc96hMuyRNkZ4XDe9La5uZGG37pBwe5z6e3WvSpu0lbc+IrRvTfN8P/BNC1ifaZmCpJIdxyM8fnWV4iglmaAIhbCnOB/n0rfHpkcVWugSR147e1bVIXhynn4XEOOJVSxyawtFEwYMD6kc1LaxuQoC5LYAyK051LXMYxyfbtTLr91NFhdvpXHyWPf+sOdlbVli5jMNkybduBVfSQd0hHTHPPerV5PusWjlz5oxtI/iFVtKB2ykA4yO3WtHbnVjig5fV5c29y1PCsyHK/N2NUzNJANki8YrQBJz1FUNQlAhKnknoKcu4qDbag1dGJqAVpJH289QRx0qiM7FdwQrEgH1rTXDOD3BzWbdO7Ts0vUk4z6V5uJpRkrtan1WX15wfInp/XQXeOCgB9Qc5/wpcs/AAXP8R6AUxWHIAP8Asnp+lOUvn5myvcA4rzJQjFrRfez3YzlKL1f3Ihkj2HG9W9Cvf+tKBnvSzbSQQTn0Pb8e/wClC1vNtq5hSVnZi4TYOXDD0AP9aRW2dAT9KU7NnBcNjpgEH/CkVwgwB+VFRXilZP0FSdpt3a9f6/UkWQEcg05WRnAZcqOoyF/ImkWQY5H6UqNGZRvUsvcBtp/AkYrmpx/ebW/r0OqtL9y9b/16r8x9/bwQMht7kTI4zjGGT2Pb/JrQ02FZLNM45rPv7eCB18i6WdGGemCvsa1NLGbOIjI4PTp1r1sMrVJK1j5zHzvhoS5m/Nqz+asif7Ism8MuQPU1FLpkBwFXaWwR35q7EMlhlgMY4NZ9/etGTbRsQwADMe3A6V01Zwpw557Hl4WFevVVKluUrrTPJhZ9xKqcke1Zow+ccVoyXFxNEYnnJU9eBz+lVhb7QSpryq2OotWgfUYTLcTDWtZ+hVIwcGnIw5B57A+lSyKuOetQEFTg04TVRGlSm6b8ix2oVgrqzKHUHJUnGaiR8YDdKswziEtiKKQMMHeuT+HpWMYcs7SNak+am3BXfa9hszRSSBo4/LXHKAkgH2J5oDoww3X3qNSAScZ9M80/cjjniorrmd2vu/yNMN7isn9/+f8Aw5BMoWTjpikUgA80sqhX4ORimiuuGtNXOOelR27i7trqeuKzPiptkuNKmAA/0fZ1+8Aev8xWj0NYnxCe5v8AVLaFYWfyUVU2KTkFEb+ZP619Lw7BurK3RHjY/XE0pdr/AJHC0orTg8O6rcuqR2b72OFViFJP0JFS3nhTXLAjztNmIP8AFEBIv5rkV9RZp2e4e3pXtzL7zLhmkt5klhkaORCGV0OCp9Qa9E0e/fWNKF3IiCdZGjkEa4BwFIbHbOTwOOOMdB57La3EBxLBJGfR1IrtPAQ3WGpg5yskO0Y9d4P8hXDm9BVMJKUlrHVP5q43NRamn/TPSzvDsN2SCasafEUErHAbGMk/d6nP5gVSL5lxtH3uKsW6CQzSBsBMDGeK+Zg7SueBXjem03bb8zTUz78CaJxnvwetMlYyhWPbI6Y6EimfZZVIYgY9R+NSSbR0YEEkjB9ea315Hc8z3faLld/Qz5AzX0eOnfmo70ObuME5xjpz3qQ4/tFfmGP/ANVR3b4vkJPAxkD61zvZnpwvzR9CfVRi2DEndnj2qrZziGByW5JxTL65W5I28IP1p1hArqzsMnJHJzSbvPQuFPkw9pkokuLj/VjapPXvTPsgEZYksTzk1fQKBgYAHaorjBhPT/gXpVOPcyjVfNyxVkc45AlJJPJP41nSYDlmfeSecVpmEO5G4HOcce5qhdRrDO6clwecngVxVdtT6TCS9+y3sMXOBkgYpw25zvH49KFJBGWK59PlBo+QZBB44rzal+l/uPcpcr0dvvuJIUKcAFs9QaRamlLmPbksoHTO7b0/KogDjjrSk3yq/wCIU0uZ2t8ncDt2HG4k9QQP50qyADAX9KHCgrt3bc/xgcfl1pVl46H8qK/vdL+gYb3d3b1X/DD1kU9v0pUMbSgMpK9wDtP4E8UBwR0/SlRovNXerMp67Tg/gTxn61zUl+82OrEP9y9b+m/y1X5i38EEEwW3uROhGchSMex/+tVrTrgJaKu4HBOVJ6VXvYYYpysE/nJjO7aV/Cqbx9cda9ClWVOo01b0PJrYV4jDx95vzas/mtDeN0CpYscDr2xWZPKJJmkjBYscncOKpAP0B4zUvzcAybfxxTxVb2keTQnAYL2E3Uu7/wBdyUGYclVNO80AfMpX9RTF7Ylyf96ngyjrhh+tePOMeqX4r/gH0UJSWzf4P/gjHcE9Pxpm1SuMcdqD16YpyntWyXLHQwb55e8VmXaen404TuITCeUzuAPY+tWRA8qSFYyyoNzEDoKqMhzkdK76VRte8rX/ABPNrU481otO34Eyu2AcZHrTtyN1xmoI3MZ46elTl42UkjJx0rlq07S0X3HZRq3hq/vIJVCtkZA7Ui4zzzSupQ4ZCP601T8wrutaFmefzXnddQ6HoKoeO7nU10iycXOyxkCqiI+MsAdwI6n/AOvWg1dHDoVh4h8MLb3cW9o94jIPKn1Br2sjxEaVe8tmmvQ8bOZxoqFWSuk/0PPNF8J3VjqunajPf2YjieK6ZA7l8AhtuNvX8ce9ausacdas4okvFtpoZS6PLu27WHzfdBOeF7djVyzsLiz06xt7tCsyQDcS+4kbmxz7DAHsKsiLfhUUsxOAFGST7UsxzytRx3u2bg2la+t9PxR3YTL1iKPtnPfrp0uedaq+paHqkliuqTSBArB0kYBgyhhwfYiuh8E6pf31ze2tzdSSxCETAOcncHVR+jmsLxZ5beI7h45Ekyqbij7hu2ANz9QenFWfA0jL4mjiUcSxSKfoFL/zUV9jXhOrgZOfWN9fS55kox9kpWV9Hc9gaNPNOFAPOPb1q1DCiWj7M7pHDHPsaYOVlfbkYx9KlhG4gDCgAZJ4AFfHRWp4NWb5d9v+HEgaVJURi3sfwqvdMfOyOADx7YFW5CxJQuTg8Gq05aOMNIoyxzvx39/1pv4bE0rOopd9DPSQrdL3J/Om3AM1yo3c8e3PFNjbNwu4deOmcU6ZitxnjisL6HqWtLTexHLzkt16Z6VoWHFuSc/eNQ3iBLKL7qu3J/nVaKVgAm/CZ5wOtP4WQ17WnoaLXcaDgb3zwB/jVeaOWaPfK+F6hRVq3jiiACKMnndnOaWdv3b/AEqmrrU54yUZ2ijG06B570BBuC5bGeSKpau4a/dfLCEYycctU9jO0V4HUkMufzxSa5PLPdCQpsjK8AdCe5rmq/wtNz2sMpLGK9rW/r1M1Co7DpmpAx/uD2qNS2OBg1MBITngD0rxa1utvvPqaHNsr/Jf5ifMwPABHTPemDkVIQdnzE7s9QePy/8Ar1GMBjySPpRCzStb8f1Cd03e+3l+gnQjIJ45yBUgkHAIP5VHkKTtBPepRIPQ/lSrrme1/T+mVhvdXxW9f6QodTzj9KdHJF5w3xl1PYHBH0PT86Aw69vpSxyQ+diWMuh4O0kEe47Z+orGgv3i0+/b8jbFP9w3e/po/lqh94kENwVt5/Oj6htpH4VWPIqW8SCKcrbzmaLqGKlT9Oar7hW06fvuyt6bHNQq3pRu29N2rP5qy/ICPU4oXZk/KT+FAOT0z7U5Q3PApt2WpSV3oOyhHKN+VKoT+Bz9P/rUfvO4XFKWX+JcH1Fczbtp+d/wOpJX1/K34kbdTQCAeSBTWUdyTn1NKqrkcheep6D8q6FFNWOaU2ndj3UoiSAjLZwUcEj646U0Rtg4PB7UpUbiAwI6BhkA04RkY2t+B5p1JqHurT11JowdT33rfqtGV3hZBnHFMBI9KtksOq5qu6fN8gJHpWtCs5+7IyxFGNP3ojpJS8CR/wAKk4Hpn09KiB5702lHWulRsrHLdXulYcx6V2XhR/8AiVEBSSJD0xxXGGuu8INmzmGMfOOfwrrwOlQ8XiJc2EfqjkLfT10truH7bJdSST7txBCxgZGBk5OcjJ4+6KsRtsZWzuwc4boat66HXWZzIiKS3AQYyPX61SU+mKwzGvVrYiVWo/e+7bY9bLVB4aK3TX5+hxfifRrXTDbz2jMsc7OpidtxUrtOQeDg7u/p1NV/Ck5t/FGnsOry+V/32Cv/ALNW540jzpdpIE3bJ2VnxwmVGBnvu2n6bPeuU0y7+w6tZ3Y6wTpJ/wB8sD/Sv0XLMRLF5dCVR3lJNP72jza9Pl56a6XR78ikoxJwvetK3jRSCvp61Rjf/RipXktnOK0VwkeenQZr5Kkrs+Pxk3Zoa0KnJ3GlMY8zkZBUDB9s/wCNPZl3Y4pEQDdnPzE55PTJxW0UtThlOVlc5hrZzdyNEu7axO0n+VUpdSjjvGWWJwMgN6r+HfiugsAWuZW559axLzR5L6/uGgkXzMklW4z9K86pGSjeB9Xhq1KVRwruyS3Ld9dQ3NpE8MismcdcY9jWe9xbLbgmXEozlBzWVLBJBIY5o2Rx1DCm5XPU/hXJPEybtbU9ejllOME1O66G5p2qfOYm6Z+UE4zWvOfMiJXB+XjmuM6DkA45wc1oW188UQRgdrAgkNn/APVW1Ku2rSOXGZdFSVSl+hLZoWutoOeD71Fq0ZWZGLggrgDPSprMlbjcO4PSotWKGdMZ3heR+Jx/Wpq/wmaYZv60vQopv9vyqQIc5LH6ZqNV5JZ8D3NPCRgAn8DXjVHvb8F+p9TTVrX/ABf6Dtiggli3sTwajYZzxwelSB0ThWIPoM1G6bW24KgDoadJvRu/zRFZK7St8n+gofB5BOOAepqQSqf4T+VMEmCflJ9+uaeJFPUfpWNZXbfL+P8Aw50Yd8sUlK3y/wCGHBk9P0pYngEw82Msh4JXIKj1HbP1BpAy+lLDJB56+bGWjJAYjIKj1GP6g1OHX7xafft8x4x/uH19NH8tVqNu0gjuHW3kMsXVWKkH8RUEcTzMQi5xU1wkaTyLC5eIH5WIwSPepNMf/SWTjDjsK9GhFSqNP8NjycTOVLDKUW27Lff57a99CrsZSVPykdRTgF7ycfWpLs5u5N45BwB7dqYpA/gY1jX92TSOrDPnpxlK2vqxwAJwsvP1zTv3iqd2G/nTSYyPmUge4zSgALlHz+Oa4pef4r9T0Y76fg/0IiaBtKtksG/hAXIJ9znj9aUrxmg7NibQ4Yfeyc7uewxxXZTs9Tz611Za69UKqqRhiPeniMr0YkelIBG4xnPanbCPutn61yTnd2vbyZ3U6dle1/NCb2Xkrx6ikCsyPKCp28sp4P1A7ilLOqHIODxkU2RfLiVlcFZOqnqvsf8AH/8AVWuHgmm7L7zDFVGnGKbXy/D+vx2KzAZzxTc09vu1HXpU9UeZV0egpIIrqfCDZS5jOcEhs5xXK10nhKZVupozjcyZUdzXXhdKqseRnS58FO6KXiRI01qXYHyQC2719vbp+tZqkAdf1rU8Q3C3l4tzG6tERsX1GOv6msoZHTr9ayxsHGpKMu515RO+GpvyRkeLkz4dMgdgFuYxjPBJV8ZHrgHB+vqK4HPNei+I1Z/Dl4BGsmNjEt/AAw+Ye/OPozV5zivseH5OWAgl0bX43/UmurV5+v6I+kEBESAY5f8ApV+UHYoX5iXTpzxuFYofHJyM+vpWisAWNHjcncM5968OlOzvY+LxVHa7t8i6VIznv3oRslhnIBxx24HFVF84yf6wgfWpmuUiVsggrmtYyVmzhnSldRWpRseHmIyD1qlCrnUZGU4IYnNWrSQLvzwRjiq1mxN7Ic5xk9OlcvY9mKadR+RFrUkd2qFo8OqnII6Guakj2MSpxg5znp6V0uplfOBz/DnH+NYEwYFgVJAzj3rnrK7uz18ufJTUVsV+xKoxXpubp/8AWoQknChQwPDbuf50feODudugUdKTGG5C/TPT9a5XZansxbas/wCvxNW1mCkSAtnG3B9ap3bBpdzcsfyxmkgk8sOp4DDg9QD/AJ/lU96GjjjVkGG+YEjkVrOV6bZx0ocmIS7+ZSVV5JJPrUgZFAwufpUa7F9T9KlDknCx/rXkVde/32Po6Oj6fddi71HO0/lUbHcy/LgdwRUwZieU/WmMCxxjAPQkVjSajrb8TasnLRP8LfiCybeNhx2Ip4kU9j+RqVIwoGKdsBNcdSvTbbsd1OhUUUrkO9ccgflUls9t5+24QmJ+GYZBT3GKcEHoKrzRlHZskZ6bRmtcLWj7TTfz2ZhjaEpUbPby0a80xkoVZHVcldxCkjqPWp7CEG8Dhvlj5J6Z7Cq+8Ben5U6C5MHmJsDLJwRnFerhpJTvJWPGx0JOlam7tq39eYw53nBDEk/Me/vUg8zA4X8qjCFh1xTwn/TQ/nXJWnFt/wDDnfQhJJb/AJDiXHVAfoaQlSOhU+9LtkHR8+x5oYtsIdR+Fc6tdW/A6nezvf5/5oizjHAOD0Penbl8xm2BVJ+6CSB/WkDlMkBSSpHzKD/PvTo2CLkrx6jmuqUrU7LW5xQjzVbt2t93zQ4CKTnj60uwj7rcUuI35GM+1HltkbW/OuJz6Xt6noKHW1/NDW4ZVlU7TyQrYJHtUc6+VIYll3qDlTgjI+hqRBHI5WXPQ4ZCMg/jwRVU5PWvQoxXKlp+p5daTdRvX9H/AMH+n0YnUGk5xjPU0dKcSNnT6V3U1ucFZ7DKfHI8MgdchgeKZ0NSq0McM8028JDGZCUAJwOvHetqMJTkox3exhXlGMW5bDVjtoLRIIFcASMwVukYbkqPbO4+2eppBkEggin/ACvHFLE6SwyrujkXlWX1H5cg8ggg4pgODz+dPFupOcnV+Lr3/wCHFhOWNlF6FfVRG+g6ksjMqGDJYdiGUr+bBR+Oe1eZ16q0cs0FxDEFMssEsSKT95mQqB+Zry+WCWFissbofRlIr6vhl82ElFa2k/yRGJ0rtd0n+n6H0AkfmOFyM571roVjRYmGSAORWVEjvMgXBJ9a1htRgHycL/jXjUtLs+Mxru0vwFBQ/cHzdgSR/nrVG4k3DJAHAyO3Sr6iMHMY+YdBmqF0p3OOOCTVzfuGGGt7Xr8yrBkqeRgHAqvbyCGZiq7nPRRVuEbo84xycZqlGpPmMGI2856VyvoexCz5kyC7dncuXGSfSqmqWwiWB12gOmDxVyUMHXORVjVbbzNFibAJjwahxumdUKqpzpro3Y5g8ZXcUjPYDk0mMAHaQp6E96e64OAAzeuOFFMJDY+Ys3cn/PNcVRaHvUHr/X9fePU8DCZYdCDz+VXLwSSWqTeZuDHOBxxVAMo64YVaSd0tjC/8J3qrZBxRSd48rJxMGpqotbP+urIYtpOBg4qcZz149KhUZ64/CnqSvBH4149dJyfKz6HDtqK5lYlLBeT+lPCMp+dCCQGAPoagI35GccVO0ryyGRzyRgc5wK53CCpSv8WljoU6rrx5V7mt/wBBcZ7mnUwOKXeK4XGXY9CMo9xwznrxTJV3ITjLAcUu8UySQYx27j1FXShJ1FYzrThGm29Sp1Hr9aQitjVJbSeIMjBpgRyBj8z3rJwD16V7tWKpzsndeR85hasq9JTlFxfmA8vucn25pyiH0/SpFC8ccU4YORgYFcU6u+/3npU6NrbfcMCoT8jYPsaH3Kh7090UryBUaMdwUqfeojLm95a27mko8vuvS/b/ACBIC2Cc4NWggHQUoxjjpRjnrXFVryqPU7aVCFNaIYYlPb8qjaJkRnDcLVg1HKoeJhkjAzgUUqsrpN6BVpR5W0tSozRm34C+YD94HHHpj+tQkjNIQV4PBppxX0cY33dz5iTUdlYXqacB8gx744pFAJ5OAOpp6gmM5/8Ar1vT3aOaveyZEeD7ip3RX07URwT9inxx1PltipoIrRkLXBlUknDJjH5Y4qdItPKSp9sKiSNk+dDj5lx1H1rqwc4xqxndWTX4M4sY5cji4u9uxy3g9JF8NXMjFnje7CoueIyFyx9sgr/3z7Vrk4/wqpoekS6LZX1vJf2syTNG6eUX6rkEYZR2bOf9kVbCMT0rrzqtTli5TjJNO2qt2KwdOU1Kye/Z+RY08f6bCTlgHXIAyevYevp71yB+IOv4MU8sFwmfuzwK39K6jLofc1T1DQdO1q4F1cPJbzjJmaJQfO/wb37/AF5rryPG4ahzRrLR6p2vt/mYYzDqc+arHmtp5o9BWMLOq7u2a01eJlwynNZt3NArtcbwYY1GdnclsAfqKlYGORwcgA8cVzpOCv0/yPlakVVtd2di+FUMTGfm9DUV1GvkyMcdCeaS2DhizABT7Ut8cWrc84q27xOSKcayV+xWtI91sSSMgn+VYpmEW/ccgsM/nV93aGw8z7QU64XrniscLvdQBnp0rlm9kj3cLTu5yb0v+RaurmOeVDEDsCAHPGKdLdyS2bQNggjGfSqoCnoQB70punBKEZQLkDpz9ajmZ0qktElsZDqVQqSQB19zUa7gOflB7etXpYdzZUj6GqrQOjEsQSeetctSLtoj2MPUi2ruw0g+wHuKNuWyBingMOSpxS7wSev5V5rdWO0T2V7Ga+L8Ry08CohIv94VKpBPWuGrGS3PSpSi9mLgA0Z4oNM3jpkZrJRbNXJRHZopM0ZquUnmFBpRTBmnUpRHGQjn5DUKjcehx61JIfk7/hUcZxk100lamzlrO9REw2gY4p4xj3qDkmpVPWsKlOx0Uql3sKTzj1peMVHnLZp3aocbWRane7HhyKeHU1DmjNZyopmkazRZ4NINpOCQPrUGTjFCsVlSQYJU55HWpp4dOVpSsu5VXEyjFuEbvt3Kch3SMR3NMxmtK6aK6Ib7OkT92RvvfhiqggKyLk5TPJr2/b0o+7GV7HgKhWmlOcLN7+X3E4tc26pnDZyarbSFKqBkH+tae7PTpWc3+skyOme3ua5sqr1Kk5qb8zoznD06VOEoLyJrdd1tt9CaDEPSnWf+oJz/ABU6SaJOByfauSpKosROMF1PQpRpvDQnN9EQ+UoHNRhMt+NaOl6bcavO6RgqqIXzjjipVsPJ5k+T69T+FTUx0aLcJO8iaeEVdpx0RQ8gyjDcfzqFreSGUBhgN0PrXU6Bpg1jUvssR8tVXc0jDJxntXoX/CJ6QdOksntg6yDDSNy+fXNVgsZiXP3Y+6t/+B5mGZ0MLGPK37/f/M8z8QxJa6W8cbk5uYlz7810axBoUZvmJUZGMmuZ18bbC1HLFr6Mk49A1dSrusYLRkjaOF5r9I5U8LT06v8AQ/HMVOUWtdf+AiOCUyLI21lAbaAw5HAqPUTi1OemO4pYiyrIWVlJcn5u/A5qvdyl7YjPIrkrtJtIMLBucZeZWNssunF2XLgEj2rPgPkxuu1SWABJHQVde92WawofXJ6nHpVHeSMkjpXHJrSx7lGM7SUtrkZ74AA6GoJF/eVYONvAOT1qCT5ST14rJnbB6iqi/h6UySIbR0B+lSq/JHX1OfamOexPXj60FJu5XZQEOOm3k0zYQNpGalYqgYZ6jkCo2PY/ezUG8WyvIBz646Y5qu2M8VYkcbTjPBxmoHYk9fyrOR107ibjjqaF++D70Khb6etKMBgPQ1hJxaaR2QUk03sWc+9KenWmUpORmvK5T2eYcOKcKiBpwPX6VMolQmJKeKYnTrSSnpQOBXRGNqaOaUr1GPHWn7sLnNRKeTS56ConC71NITstCReBTjyKYO9L2rFrU3jLSwuaPYU3NHGaOUXMPozzSZozk1HKXzD+tLjjrTaUnArJpmya3JIjhf6VUcHzJcYx15qxuqLPLkc+tduWQarSfdHnZxNPDxS6P9CNQTbsQcAN0p1pY3N9MscMbuzdABmiEKSwI75wa9b8E2drFpEUyRr5sg+Z8cnmpxOJnSq+yhvJ7vp/mZwpweHjVlsla33mxoGnrp+iWluYQkiRAOO+7v8ArViaxtGfzTbx+ZjAbaM1bqCdgF61nUpU40rSSdu5yqcpTcl1KcdnDZzRuiKCe4GOvWtIHIqpct/o8ZB7ipI5h5YNYYZ06E5U46LRjnzTSkzzG0kWWXy3VZELZG4ZwfWrMtxeQsf9HZs8LtYEfyrOilWLUMqOpJxWuZ2I3E4FffUK3KrSVz82xtC81JLdEYkZIHkcFXYFsMMEelZUtzI6bCQMnnHFWLq7WWTy0PynriqWxTjBIOe1YVqnPK6OzCUFTjeS1IWJODyRn8KQEgBvoetWwgVeAMfSm7QcYrGx3KaKRcYyDxj9ahkfLc8ZqadfnOB271WcAgEgcevaoZ000tx3mjPI/WmyOrAg5/oaFHH9aikHYHnHepNYpXEL5QjJ6c0nlkjO4Y/+tTMgQ8HIx70KcHueec1JtbsRSoR15HtUIA/D2qWQ7pOecAUwpzkVy1aqUuU9PD0W4qb1FDccUmwZzRtx2pQK5nZfCztSbtzIdQTRt96NvvWXumtpCg0oNMKsMYGfoKljTJOSePYipmko83Qqm258ltSJlLtgU7ymxVoKoXpSbB2Nc/1t7LY6vqS3b1Ku0rnIIoB96t7M1BJEFOQKuniYzdnuZ1MLKCuthoPFLTV5OBSnI61bjrYhS0uBopuaM4p8pPNqPzTlPNMFLkDjNZuN9DRStqyQU2V8YAPNNEynjOKikfc5wciilRbn7yHVrxUPde4/eRT4iCGzkc1WD1ZtwGRs9M9Pyr0sPT5ZnkY2pzUt+o0HErA+1ereCpsaHb4Pc/zNeUSt5b5Knnjpiuw0HxTZ6VoyJMzNICcIvWvGzmnVVSFSnFvXp6HZg5KeF5L/ANXPUPOwOfSsnV9dsdNQm5uEVscJnJP4V5zqnjvUr1Wjtv8ARoz/AHfvH8a5eaSWZy8rs7NzuY9aqODxWIjafuL8f8v62MnOjTeru/L/ADO41X4iySxiGxgCqP435NU9P8falb7xcItxkggcDH5VySjHBHJGBnilXEbrnnIrtWUYa3vJt976mTx09VFK3a39P8TpITtmRmPQ9KuzXXmDZHwuMH3qiilCR7elOWQF2GPxxXvp2Vj5GdNSlzdh23b34x69KVVAOcgn+tMWVWJ5FHmhhwPwo0HZjyQVGCcevTtRyRwx465phkUggHJ69KFdCgwRu4ouFilKzK5ViPYjioZOQf6VoyxpMmw9SOCR+tZ0i+TIUIJz90+orOSsddKSlp1BVZt2wEkCkaM7funr61Kgwx5ORjpUF9PKCQAAuMEj61L0VzSN5SsiESrggEfQGgcLheBnr+FVEG51HqQOa0FXAHXIPpWcG5HXWgqexUbG/jHSlGe9Ew2y/hRn5a8/Er32exg2vZIXigCmg0ufeuZxZ1qSFxQetJmjNJJjckOwTyCRUi9OTmos5HWlBI78VnOF1Y1hNJ3LGaX+VRB+KdmuN02jtVRMeKZIflIA5NG6m7sjNVCDUrkzmnGwxFwOetONGaaTxXRdt3ZzWSVkNIFNxzTqcCK1UmjFxTFRD34oaNQpwO3enK3vTs1zupNSudMacHGxQ7UZFXSin+EflUMsS8EDA74r0KWJjOSi1Y86rhJ04uSdyv3q7Z52tTRBnt8vv3P1qykWxRznj1r04Qs7nh16ylHlKc6/MpAwKWKHj5vyIp8+5ZPocD8qAG7cY6U7ak8z5EI0W3lTx356011I7ewzUmCCRk8jg0EDaMjI9MUWEpMg8lyOR+JpFid2AI9qnAHPXA5x0xT7ZJZrkRW+GbB5PQ1nUnCnFzm7JGtNVKkuSCu2bBcjKAZxUse3Z0BxUscSPuypJyaclugGec4xXckz5+VSOxVnwBwO1VduW5z9a0ZLMyLlCMgcD1FUgvJyMHPIz3qZI1pTTWhHz7kc9ulJk4BHQetS7N24E85P8hUsVqzYxgknnmpszRzSWpEMlQSDkjkVHNCsw2YyT0+tWXQxnHH3c9ajBy6r1Ge1NroKMuqKQLqzJLw6nHpn8KSVPMUhh8pOMdKn1D5r4lDg4HTuMd6iWbzF7AjrjNQ+x0RbaU0ZzQtE8ee7CrqrgjgetP25G8YyORQMbecAnpmojFR2NqlZztcoTj98Oe3Wk6DmnXP+uX/dHaoN3PrXDWg5T0PZwtRRopsk/wAKUVECc57U4GsZU2jpjUTJO9J9KZml3dan2bL9oh/alzUYY0u7modNlxqIkLeho3UzdSZPFT7Ir2pMGpN2ajDZoDZpeysV7W6JA2KTNNz70Zpcge0F4oGDTSaM1XKSpakq4p2ajHXrT6wnHU6IS0FNIaM0hOelTFWKk7j4ZNrbG5HY/wBKsEggHGABVNSFlXIz8wGKuEjAwPbP0r3cJNzp69D5XMaUadb3VvqVJ1O7ceOeo+lMLMEwE4PcHHapLsYQkZwD39at6Ykcs7mUZKcDPas8biVhaTqtXsbYDCvF1I007f8AAK0NtdXI/dQEr6kUsthedTCwxnmusiZVXCgBfSs3W9Q8uHyI2w7/AHj6Cvm6Gd4zE11SpRWp9BUynB0KbnUvp1v/AMA54A7SScHA49au6HuGrRY6BTmqJ3MpwG6D866DSbb7ND5jD94/JPp7V6udYmNHCuD3lp/wTzcnw0quI51tH+kj/9k=");

		System.out.println("meter:" + testMeter.toString());

		HttpEntity<Meter> request = new HttpEntity<>(testMeter, headers);

		MyObj myObj = new MyObj();

		// build the request
		// HttpEntity<Meter> entity = new HttpEntity<>(testMeter, headers);

		// send POST request
		try {
			ResponseEntity<Meter> response = restTemplate.postForEntity("http://34.81.111.182:8080/meter/api/", request,
					Meter.class);
			System.out.println("StatusCode :" + response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (HttpClientErrorException ex) {
			System.out.println("HttpClientErrorException" + ex);
		}

		// check response

	}
}

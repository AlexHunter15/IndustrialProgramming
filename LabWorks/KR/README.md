## Задача
* В  текстовом файле Student2.txt находятся данные о студентах :  дата рождения(число месяца,месяц,год),идентификационный номер(с буквой Е, е -это запись в экпоненциальном виде),фамилия, средний бал, номера предметов(которые сданы)
 Каждая запись о студенте - в отдельной строке. Разделители : восклицательный знак, пробел, подчеркивание, точка с запятой ?, _;

* В  текстовом файле Teacher.txt находятся данные о преподавателях : фамилия, номер предмета

* Разработать классы (Student, ClassBD):   
- Класс Student - содержит информацию об одном студенте
- Класс ClassBD - содержит:
	List (объекты класса Student);
	Map (список преподавателей )(для MAP, ключ - код предмета);

- В классах должны быть  методы :
	1)	Переопределенные  метод toString и методы сравнения в классе Student

	2)	Метод чтения данных из текстового файла

	3)	Метод записывающий преподавателей в Map(для MAP, ключ- код предмета, значение- фамилия преподавателя)
			-результат в текстовый файл rezultmap.txt	

	4)    Метод выводящий данные: фамилию  студента и фамилии преподавателей,
		 у которых есть задолженности по соответсвующему предмету
			-результат в текстовый файл rezuldebt.txt	

	5)	Cортировка объекта List по полю фамилия
			-результат в текстовый файл rezultsort.txt

	6)	Запись  Map (или хотя бы данных файла Teacher.txt) в XML-формат
		и записывающий  в результирующий текстовый файл rezXML.txt
